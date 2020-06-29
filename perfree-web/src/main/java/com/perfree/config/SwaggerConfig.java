package com.perfree.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger2配置
 * @author Perfree
 */
@Configuration
public class SwaggerConfig {

    @Value(value = "${swagger.enabled}")
    private Boolean swaggerEnabled;

    @Value(value = "${project.name}")
    private String projectName;

    @Value(value = "${swagger.description}")
    private String swaggerDescription;

    @Value(value = "${project.version}")
    private String version;

    @Value(value = "${author.name}")
    private String author;

    @Value(value = "${author.link}")
    private String authorLink;

    @Value(value = "${author.email}")
    private String authorEmail;

    @Value(value = "${swagger.scan}")
    private String swaggerPackageScan;

    /**
     * Token设置
     * @return List<Parameter>
     */
    private List<Parameter> getTokenPar(){
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("Authorization")
                .description("认证信息")
                .modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerEnabled)
                .pathMapping("/")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerPackageScan))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(getTokenPar());
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(projectName)
                .description(swaggerDescription)
                .contact(new Contact(author, authorLink, authorEmail))
                .version(version)
                .build();
    }
}
