package com.perfree.controller;

import com.perfree.common.Pager;
import com.perfree.model.Comment;
import com.perfree.model.User;
import com.perfree.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName CommentController
 * @Author Majz
 * @Date 2020/7/2 9:22:16
 * @Version 1.0
 **/

@Api(tags = "评论接口")
@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @ApiOperation(value = "评论列表分页", notes = "评论列表分页")
    @PostMapping("/list")
    public Pager<Comment> list(@RequestBody Pager<Comment> pager){
        return commentService.list(pager);
    }
}
