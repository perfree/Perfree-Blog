package com.perfree.controller;

import com.perfree.common.Pager;
import com.perfree.model.Category;
import com.perfree.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "分类接口")
@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController extends BaseController{
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "分类列表分页", notes = "分类列表分页")
    @PostMapping("/list")
    public Pager<Category> list(@RequestBody Pager<Category> pager){
        return categoryService.list(pager);
    }
}
