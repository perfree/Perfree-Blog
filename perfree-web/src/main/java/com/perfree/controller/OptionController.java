package com.perfree.controller;

import com.perfree.common.Pager;
import com.perfree.common.ResponseBean;
import com.perfree.model.Option;
import com.perfree.model.User;
import com.perfree.service.OptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName OptionController
 * @Author Majz
 * @Date 2020/7/2 9:23:48
 * @Version 1.0
 **/

@Api(tags = "配置接口")
@RestController
@CrossOrigin
@RequestMapping("/option")
public class OptionController {

    @Autowired
    OptionService optionService;

    @ApiOperation(value = "配置列表分页", notes = "配置列表分页")
    @PostMapping("/list")
    public Pager<Option> list(@RequestBody Pager<Option> pager){
        return optionService.list(pager);
    }

    @ApiOperation(value = "添加配置", notes = "添加配置")
    @PostMapping("/add")
    public ResponseBean addOption(@RequestBody Option option){
        return optionService.addOption(option);
    }

    @ApiOperation(value = "删除配置", notes = "删除配置")
    @DeleteMapping("/delete/{id}")
    public ResponseBean delOption(@PathVariable("id") Integer id){
        return optionService.delOption(id);
    }

    @ApiOperation(value = "修改配置", notes = "修改配置")
    @PutMapping("/update")
    public ResponseBean updateOption(@RequestBody Option option){return  optionService.updateOption(option);}
}
