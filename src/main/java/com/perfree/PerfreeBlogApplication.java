package com.perfree;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.util.Date;

@EnableSwagger2
@SpringBootApplication
@MapperScan("com.perfree.mapper")
public class PerfreeBlogApplication implements CommandLineRunner {

    @Value("${server.port}")
    private int serverPort;

    public static void main(String[] args) {
        SpringApplication.run(PerfreeBlogApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(new Date() + ", " + address + ":"+ serverPort +" >>>>>>>>已启动完成...");
    }
}
