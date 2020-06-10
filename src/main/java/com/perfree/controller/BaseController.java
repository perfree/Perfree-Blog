package com.perfree.controller;

import com.perfree.common.JwtUtil;
import com.perfree.model.User;
import com.perfree.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller基类
 * @author Perfree
 */
@RestController
public class BaseController {

    protected final static Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
    @Autowired
    private UserService userService;

    /**
     * 获取当前登录的用户信息
     * @return User 用户信息
     */
    public User getUser (){
        Subject subject = SecurityUtils.getSubject();
        String token = subject.getPrincipals().getPrimaryPrincipal().toString();
        String account = JwtUtil.getUsername(token);
        return userService.getUserByAccount(account);
    }
}
