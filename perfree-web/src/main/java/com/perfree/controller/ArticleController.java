package com.perfree.controller;

import com.perfree.common.Pager;
import com.perfree.common.ResponseBean;
import com.perfree.model.Article;
import com.perfree.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Api(tags = "文章接口")
@RestController
@CrossOrigin
@RequestMapping("/article")
@Validated
public class ArticleController extends BaseController{

    @Autowired
    private ArticleService articleService;

    @ApiOperation(value = "添加文章", notes = "添加文章")
    @PostMapping("/add")
    public ResponseBean add(@RequestBody @Validated Article article, BindingResult bindingResult, HttpServletRequest request){
        //判断BindingResult中是否有错误信息
        if(bindingResult.hasErrors()){
            return new ResponseBean(500, Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage(), null);
        }
        article.setUserId(getUser(request).getId());
        return articleService.add(article);
    }

    @ApiOperation(value = "文章列表分页", notes = "文章列表分页")
    @PostMapping("/list")
    public Pager<Article> list(@RequestBody Pager<Article> pager){
        return articleService.list(pager);
    }

    @ApiOperation(value = "删除文章", notes = "删除文章")
    @DeleteMapping("/delete/{id}")
    public ResponseBean delete(@PathVariable("id") Long id){
        return articleService.delete(id);
    }
}
