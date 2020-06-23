package com.perfree.controller;

import com.perfree.service.CategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "分类接口")
@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController extends BaseController{
    @Autowired
    private CategoryService categoryService;
}
