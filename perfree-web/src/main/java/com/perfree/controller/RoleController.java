package com.perfree.controller;

import com.perfree.common.Pager;
import com.perfree.model.Role;
import com.perfree.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 权限处理相关
 * @author Perfree
 */
@Api(tags = "角色处理接口")
@RestController
@CrossOrigin
@RequestMapping("/api/role")
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "角色列表分页", notes = "角色列表分页")
    @PostMapping("/list")
    public Pager<Role> list(@RequestBody Pager<Role> pager){
        return roleService.list(pager);
    }
}
