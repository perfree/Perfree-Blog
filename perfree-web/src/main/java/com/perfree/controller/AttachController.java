package com.perfree.controller;

import com.perfree.common.Pager;
import com.perfree.model.Attach;
import com.perfree.model.Category;
import com.perfree.service.AttachService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "附件接口")
@RestController
@CrossOrigin
@RequestMapping("/attach")
public class AttachController extends BaseController{

    @Autowired
    private AttachService attachService;

    @ApiOperation(value = "图片列表分页", notes = "图片列表分页")
    @PostMapping("/imageList")
    public Pager<Attach> imageList(@RequestBody Pager<Attach> pager){
        return attachService.imageList(pager);
    }
}
