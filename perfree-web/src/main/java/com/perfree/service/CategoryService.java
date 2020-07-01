package com.perfree.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.perfree.common.Pager;
import com.perfree.common.ResponseBean;
import com.perfree.mapper.CategoryMapper;
import com.perfree.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 分类列表
     * @param pager 分页信息
     * @return Pager<Category>
     */
    public Pager<Category> list(Pager<Category> pager) {
        Category category = pager.getForm();
        PageHelper.startPage(pager.getPageIndex(), pager.getPageSize());
        List<Category> categories = categoryMapper.list(category);
        PageInfo<Category> pageInfo = new PageInfo<>(categories);
        pager.setCode(0);
        pager.setTotal(pageInfo.getTotal());
        pager.setData(pageInfo.getList());
        return pager;
    }


    /**
     * 添加分类
     * @param category 分类
     * @return ResponseBean
     */
    public ResponseBean add(Category category) {
        category.setCreateTime(new Date());
        category.setUpdateTime(new Date());
        int count = categoryMapper.add(category);
        if (count > 0){
            return new ResponseBean(200,"添加成功",null);
        }
        return new ResponseBean(500,"添加失败",null);
    }

    /**
     * 更新分类
     * @param category 分类
     * @return ResponseBean
     */
    public ResponseBean update(Category category) {
        category.setUpdateTime(new Date());
        int count = categoryMapper.update(category);
        if (count > 0){
            return new ResponseBean(200,"更新成功",null);
        }
        return new ResponseBean(500,"更新失败",null);
    }

    /**
     * 删除分类
     * @param id id
     * @return ResponseBean
     */
    public ResponseBean delete(Integer id) {
        int count = categoryMapper.delete(id);
        if (count > 0) {
            return new ResponseBean(200, "删除成功", null);
        }
        return new ResponseBean(500,"删除失败",null);
    }

    /**
     * 获取所有分类
     * @return ResponseBean
     */
    public ResponseBean all() {
        List<Category> categories = categoryMapper.all();
        return new ResponseBean(200, "获取所有分类", categories);
    }
}
