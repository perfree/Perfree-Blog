package com.perfree.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.perfree.common.Pager;
import com.perfree.mapper.CategoryMapper;
import com.perfree.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
