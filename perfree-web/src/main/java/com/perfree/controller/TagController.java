package com.perfree.controller;

import com.perfree.common.Pager;
import com.perfree.common.ResponseBean;
import com.perfree.model.Tag;
import com.perfree.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "标签接口")
@RestController
@CrossOrigin
@RequestMapping("/tag")
public class TagController extends BaseController{
    @Autowired
    private TagService tagService;

    @ApiOperation(value = "标签列表分页", notes = "标签列表分页")
    @PostMapping("/list")
    public Pager<Tag> list(@RequestBody Pager<Tag> pager){
        return tagService.list(pager);
    }

    @ApiOperation(value = "添加标签", notes = "添加标签")
    @PostMapping("/add")
    public ResponseBean add(@RequestBody Tag tag){
        return tagService.add(tag);
    }

    @ApiOperation(value = "更新标签", notes = "更新标签")
    @PostMapping("/update")
    public ResponseBean update(@RequestBody Tag tag){
        return tagService.update(tag);
    }

    @ApiOperation(value = "删除标签", notes = "删除标签")
    @DeleteMapping("/delete/{id}")
    public ResponseBean delete(@PathVariable("id") Integer id){
        return tagService.delete(id);
    }

    @ApiOperation(value = "获取所有标签", notes = "获取所有标签")
    @GetMapping("/all")
    public ResponseBean all(){
        return tagService.all();
    }
}
