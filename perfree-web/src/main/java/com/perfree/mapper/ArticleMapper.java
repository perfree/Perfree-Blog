package com.perfree.mapper;

import com.perfree.model.Article;
import com.perfree.model.ArticleTag;
import com.perfree.model.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArticleMapper {
    /**
     * 添加文章
     * @param article 文章
     * @return int
     */
    Long add(Article article);

    /**
     * 添加文章标签数据
     * @param list 标签
     * @return int
     */
    int addTags(List<ArticleTag> list);
}
