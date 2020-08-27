package com.perfree.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Controller
public class IndexController implements ErrorController {
    @RequestMapping("/")
    public String index()
    {
        return "index.html";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request){
        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            System.out.println(attributeNames.nextElement());
        }
        //获取statusCode:401,404,500
        String path = request.getAttribute("javax.servlet.forward.servlet_path").toString();
        System.out.println(path);
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
       if(statusCode == 404){
            //对应的是/error/404.html、/error/404.jsp等，文件位于/templates下面
            return "index.html";
        }
        return null;
    }
}
