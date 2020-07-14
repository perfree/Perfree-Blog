package com.perfree.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.perfree.common.Pager;
import com.perfree.common.ResponseBean;
import com.perfree.mapper.OptionMapper;
import com.perfree.model.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName OptionService
 * @Author Majz
 * @Date 2020/7/1 11:40:31
 * @Version 1.0
 **/
@Service
public class OptionService {

    @Autowired
    OptionMapper optionMapper;

    /**
     * 配置列表，分页
     * @param pager
     * @return
     */
    public Pager<Option> list(Pager<Option> pager) {
        Option option = pager.getForm();
        PageHelper.startPage(pager.getPageIndex(),pager.getPageSize());
        List<Option> options = optionMapper.list(option);
        PageInfo<Option> pageInfo = new PageInfo<>(options);
        pager.setCode(200);
        pager.setTotal(pageInfo.getTotal());
        pager.setData(pageInfo.getList());
        return pager;
    }


    /**
     * 添加配置
     * @param option
     * @return
     */
    public ResponseBean addOption(Option option) {
        Option optionByKey = optionMapper.getByKey(option.getKey());
        if(optionByKey != null) {
            return new ResponseBean(500,"配置名已存在",null);
        }
        option.setCreateTime(new Date());
        option.setUpdateTime(new Date());
        Integer count = optionMapper.addOption(option);
        if(count > 0) {
            return new ResponseBean(200,"添加成功",null);
        } else {
            return new ResponseBean(500,"添加失败",null);
        }
    }

    /**
     * 删除配置
     * @param id
     * @return
     */
    public ResponseBean delOption(Integer id) {
        Integer count = optionMapper.delOption(id);
        if(count > 0) {
            return new ResponseBean(200,"删除成功",null);
        } else {
            return new ResponseBean(500,"删除失败",null);
        }
    }

    /**
     * 修改配置
     * @param option
     * @return
     */
    public ResponseBean updateOption(Option option) {
        Option optionByKey = optionMapper.getByKey(option.getKey());
        if(optionByKey != null && optionByKey.getId() != option.getId()) {
            return new ResponseBean(500,"配置名已存在",null);
        }
        option.setUpdateTime(new Date());
        Integer count = optionMapper.updateOption(option);
        if(count > 0) {
            return new ResponseBean(200,"修改成功",null);
        } else {
            return new ResponseBean(500,"修改失败",null);
        }
    }

    /**
     * 网站配置
     * @param options 配置信息
     * @return ResponseBean
     */
    public ResponseBean webOption(List<Option> options) {
        for (Option option:options) {
            option.setUpdateTime(new Date());
            optionMapper.webOption(option);
        }
        return new ResponseBean(200,"修改成功",null);
    }

    /**
     * 获取网站配置
     * @return ResponseBean
     */
    public ResponseBean getWebOption() {
        List<Option> webOptions = optionMapper.getWebOption();
        HashMap<String,String> result = new HashMap<>();
        for (Option option:webOptions) {
            result.put(option.getKey(),option.getValue());
        }
        return new ResponseBean(200,"获取成功", result);
    }
}
