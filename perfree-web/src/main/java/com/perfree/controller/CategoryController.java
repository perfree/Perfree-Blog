package com.perfree.controller;

import com.perfree.common.Pager;
import com.perfree.common.ResponseBean;
import com.perfree.model.Category;
import com.perfree.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "分类接口")
@RestController
@CrossOrigin
@RequestMapping("/api/category")
public class CategoryController extends BaseController{
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "分类列表分页", notes = "分类列表分页")
    @PostMapping("/list")
    public Pager<Category> list(@RequestBody Pager<Category> pager){
        return categoryService.list(pager);
    }

    @ApiOperation(value = "添加分类", notes = "添加分类")
    @PostMapping("/add")
    public ResponseBean add(@RequestBody Category category){
        return categoryService.add(category);
    }

    @ApiOperation(value = "更新分类", notes = "更新分类")
    @PostMapping("/update")
    public ResponseBean update(@RequestBody Category category){
        return categoryService.update(category);
    }

    @ApiOperation(value = "删除分类", notes = "删除分类")
    @DeleteMapping("/delete/{id}")
    public ResponseBean delete(@PathVariable("id") Integer id){
        return categoryService.delete(id);
    }

    @ApiOperation(value = "获取所有分类", notes = "获取所有分类")
    @GetMapping("/all")
    public ResponseBean all(){
        return categoryService.all();
    }
}
