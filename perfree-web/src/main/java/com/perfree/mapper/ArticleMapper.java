package com.perfree.mapper;

import com.perfree.model.Article;
import org.springframework.stereotype.Component;

@Component
public interface ArticleMapper {
    /**
     * 添加文章
     * @param article 文章
     * @return int
     */
    int add(Article article);
}
