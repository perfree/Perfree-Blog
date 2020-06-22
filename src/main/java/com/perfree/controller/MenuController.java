package com.perfree.controller;

import com.perfree.common.Pager;
import com.perfree.model.Menu;
import com.perfree.model.User;
import com.perfree.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "菜单接口")
@RestController
@CrossOrigin
@RequestMapping("/menu")
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "菜单列表分页", notes = "菜单列表分页")
    @PostMapping("/list")
    public Pager<Menu> list(@RequestBody Pager<Menu> pager){
        return menuService.list(pager);
    }
}
