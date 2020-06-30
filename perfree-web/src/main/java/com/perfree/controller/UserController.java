package com.perfree.controller;

import com.perfree.common.Pager;
import com.perfree.common.ResponseBean;
import com.perfree.model.User;
import com.perfree.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户Controller
 */
@Api(tags = "用户接口")
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户列表分页", notes = "用户列表分页")
    @PostMapping("/list")
    public Pager<User> list(@RequestBody Pager<User> pager){
        return userService.list(pager);
    }

    @ApiOperation(value = "添加用户", notes = "添加用户")
    @PostMapping("/add")
    public ResponseBean addUser(@RequestBody User user){ return userService.addUser(user); }

    @ApiOperation(value = "修改用户", notes = "修改用户")
    @PutMapping("/update")
    public ResponseBean updateUser(@RequestBody User user){return  userService.updateUser(user);}

    @ApiOperation(value = "更新状态", notes = "更新状态")
    @PutMapping("/updateStatus")
    public ResponseBean updateStatus(@RequestBody User user){return userService.updateStatus(user);}

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @DeleteMapping("/delete/{id}")
    public ResponseBean delete(@PathVariable("id") Long id, HttpServletRequest request){
        return userService.deleteUser(id, getUser(request));
    }
}
