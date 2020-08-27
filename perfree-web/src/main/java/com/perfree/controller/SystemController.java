package com.perfree.controller;

import com.perfree.common.ResponseBean;
import com.perfree.model.Menu;
import com.perfree.model.User;
import com.perfree.service.MenuService;
import com.perfree.service.UserService;
import com.perfree.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 系统级Controller，用于处理登录，获取菜单等操作
 */
@Api(tags = "系统级处理接口")
@Controller
@CrossOrigin
public class SystemController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "登录接口", notes = "传入用户名及密码，返回token")
    @PostMapping("/api/login")
    @ResponseBody
    public ResponseBean login(@RequestBody User user) {
        User userBean = userService.getUserByAccount(user.getAccount());
        if (userBean == null || StringUtils.isBlank(userBean.getAccount())){
            return new ResponseBean(404, "账户不存在",null);
        }
        String password = new SimpleHash("MD5", user.getPassword(), userBean.getSalt(), 1024).toString();
        user.setPassword(password);
        if (userBean.getPassword().equals(user.getPassword())) {
            return new ResponseBean(200, "登陆成功", JwtUtil.sign(user.getAccount(), user.getPassword()));
        } else {
            return new ResponseBean(500, "密码错误",null);
        }
    }

    @GetMapping(path = "/401/{message}")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ResponseBean unauthorized(@PathVariable String message) {
        if (StringUtils.isNotBlank(message)){
            return new ResponseBean(401, message, null);
        }
        return new ResponseBean(401, "Unauthorized", null);
    }

    @ApiOperation(value = "获取用户信息", notes = "获取当前登录的用户信息")
    @GetMapping("/api/getUserInfo")
    @ResponseBody
    public ResponseBean getUserInfo(HttpServletRequest request){
        User user = getUser(request);
        user.setRoles(null);
        user.setSalt(null);
        user.setPassword(null);
        return new ResponseBean(200, "用户信息", user);
    }

    @ApiOperation(value = "获取用户后台菜单信息", notes = "获取当前登录的用户所拥有的后台菜单信息")
    @GetMapping("/api/getAdminMenuByAccount")
    @ResponseBody
    public ResponseBean getAdminMenuByAccount(HttpServletRequest request){
        User user = getUser(request);
        List<Menu> menuByAccount = menuService.getMenuByAccount(user.getAccount(), 0);
        return new ResponseBean(200, "后台菜单信息", menuByAccount);
    }

    @ApiOperation(value = "获取用户前台菜单信息", notes = "获取当前登录的用户所拥有的前台菜单信息")
    @GetMapping("/api/getPortalMenuByAccount")
    @ResponseBody
    public ResponseBean getPortalMenuByAccount(HttpServletRequest request){
        User user = getUser(request);
        List<Menu> menuByAccount = menuService.getMenuByAccount(user.getAccount(), 1);
        return new ResponseBean(200, "前台菜单信息", menuByAccount);
    }

   /* @RequestMapping("/")
    public String index(){
        return "Perfree-Blog-Page/index.html";
    }*/

    public static void main(String[] args) {
        String password = "123456";
        /*String uuid = UUID.randomUUID().toString().replaceAll("-","");
        System.out.println(uuid);*/
        Object obj = new SimpleHash("MD5", password, "557ad0b706834690b0472f41e422a8d4", 1024);
        System.out.println(obj);
    }
}
