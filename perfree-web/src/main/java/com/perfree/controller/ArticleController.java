package com.perfree.controller;

import com.perfree.common.ResponseBean;
import com.perfree.model.Article;
import com.perfree.model.Category;
import com.perfree.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "文章接口")
@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController extends BaseController{

    @Autowired
    private ArticleService articleService;

    @ApiOperation(value = "添加文章", notes = "添加文章")
    @PostMapping("/add")
    public ResponseBean add(@RequestBody Article article, HttpServletRequest request){
        article.setUserId(getUser(request).getId());
        return articleService.add(article);
    }
}
