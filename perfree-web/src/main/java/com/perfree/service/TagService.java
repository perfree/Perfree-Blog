package com.perfree.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.perfree.common.Pager;
import com.perfree.common.ResponseBean;
import com.perfree.mapper.TagMapper;
import com.perfree.model.Category;
import com.perfree.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagMapper tagMapper;
    /**
     * 标签列表分页
     * @param pager 分页
     * @return Pager<Tag>
     */
    public Pager<Tag> list(Pager<Tag> pager) {
        Tag tag = pager.getForm();
        PageHelper.startPage(pager.getPageIndex(), pager.getPageSize());
        List<Tag> tags = tagMapper.list(tag);
        PageInfo<Tag> pageInfo = new PageInfo<>(tags);
        pager.setCode(0);
        pager.setTotal(pageInfo.getTotal());
        pager.setData(pageInfo.getList());
        return pager;
    }

    /**
     * 添加标签
     * @param tag 标签
     * @return ResponseBean
     */
    public ResponseBean add(Tag tag) {
        tag.setCreateTime(new Date());
        tag.setUpdateTime(new Date());
        int count = tagMapper.add(tag);
        if (count > 0){
            return new ResponseBean(200,"添加成功",null);
        }
        return new ResponseBean(500,"添加失败",null);
    }

    /**
     * 更新标签
     * @param tag 标签
     * @return ResponseBean
     */
    public ResponseBean update(Tag tag) {
        tag.setUpdateTime(new Date());
        int count = tagMapper.update(tag);
        if (count > 0){
            return new ResponseBean(200,"更新成功",null);
        }
        return new ResponseBean(500,"更新失败",null);
    }

    /**
     * 删除标签
     * @param id id
     * @return ResponseBean
     */
    public ResponseBean delete(Integer id) {
        int count = tagMapper.delete(id);
        if (count > 0) {
            return new ResponseBean(200, "删除成功", null);
        }
        return new ResponseBean(500,"删除失败",null);
    }

    /**
     * 获取所有标签
     * @return ResponseBean
     */
    public ResponseBean all() {
        List<Tag> tags = tagMapper.all();
        return new ResponseBean(200, "获取所有标签", tags);
    }
}
