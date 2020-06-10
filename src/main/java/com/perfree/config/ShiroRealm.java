package com.perfree.config;

import com.perfree.common.JwtToken;
import com.perfree.common.JwtUtil;
import com.perfree.exception.UnauthorizedException;
import com.perfree.model.Role;
import com.perfree.model.User;
import com.perfree.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 自定义ShiroRealm
 */
@Component
public class ShiroRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LogManager.getLogger(ShiroRealm.class);

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = JwtUtil.getUsername(principals.toString());
        User user = userService.getUserByAccount(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Role role:user.getRoles()) {
            simpleAuthorizationInfo.addRole(role.getRoleCode());
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws UnauthorizedException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JwtUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token不存在!");
        }
        User userBean = userService.getUserByAccount(username);
        if (userBean == null) {
            throw new AuthenticationException("用户不存在!");
        }
        if (!JwtUtil.verify(token, username, userBean.getPassword())) {
            throw new AuthenticationException("Token验证失败或已过期!");
        }
        return new SimpleAuthenticationInfo(token, token, "shiroRealm");
    }
}
