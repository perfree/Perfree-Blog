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

    /**
     * 文章列表
     * @param article 文章
     * @return List<Article>
     */
    List<Article> list(Article article);

    /**
     * 删除文章
     * @param id id
     * @return int
     */
    int delete(Long id);

    /**
     * 删除文章标签
     * @param id 文章id
     */
    void deleteArticleTag(Long id);

    /**
     * 根据文章id获取数据
     * @param id id
     * @return Article
     */
    Article getArticleById(Long id);

    /**
     * 更新文章
     * @param article 文章
     * @return int
     */
    int update(Article article);
}
