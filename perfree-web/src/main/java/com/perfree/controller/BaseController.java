package com.perfree.controller;

import com.perfree.model.User;
import com.perfree.service.UserService;
import com.perfree.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller基类
 * @author Perfree
 */
public class BaseController {

    protected final static Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
    @Autowired
    private UserService userService;

    /**
     * 获取当前登录的用户信息
     * @return User 用户信息
     */
    public User getUser (HttpServletRequest request){
        String token = request.getHeader("Authorization");
        String account = JwtUtil.getUsername(token);
        return userService.getUserByAccount(account);
    }
}
