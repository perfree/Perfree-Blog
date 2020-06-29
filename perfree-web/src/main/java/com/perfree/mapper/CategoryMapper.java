package com.perfree.mapper;

import com.perfree.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryMapper {
    /**
     * 分类列表
     * @param category
     * @return
     */
    List<Category> list(Category category);
}
