package com.perfree.controller;

import com.perfree.common.Pager;
import com.perfree.common.ResponseBean;
import com.perfree.model.Menu;
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

    @ApiOperation(value = "添加菜单", notes = "添加菜单")
    @PostMapping("/add")
    public ResponseBean add(@RequestBody Menu menu){
        return menuService.add(menu);
    }

    @ApiOperation(value = "删除菜单", notes = "删除菜单")
    @DeleteMapping("/delete/{id}")
    public ResponseBean delete(@PathVariable("id") Integer id){
        return menuService.deleteMenu(id);
    }

    @ApiOperation(value = "更新状态", notes = "更新状态")
    @PutMapping("/updateStatus")
    public ResponseBean updateStatus(@RequestBody Menu menu){
        return menuService.updateStatus(menu);
    }
}
