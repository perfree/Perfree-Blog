package com.perfree.controller;

import com.perfree.common.Pager;
import com.perfree.model.Permission;
import com.perfree.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 权限处理相关
 * @author Perfree
 */
@Api(tags = "权限处理接口")
@RestController
@CrossOrigin
@RequestMapping("/permission")
public class PermissionController extends BaseController {

    @Autowired
    private PermissionService permissionService;


    @ApiOperation(value = "权限列表分页", notes = "权限列表分页，搜索可传入权限名模糊搜索")
    @PostMapping("/list")
    public Pager<Permission> list(@RequestBody Pager<Permission> pager){
        return permissionService.list(pager);
    }

}
