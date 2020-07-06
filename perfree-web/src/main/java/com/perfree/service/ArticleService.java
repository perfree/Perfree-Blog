package com.perfree.service;

import com.perfree.common.ResponseBean;
import com.perfree.mapper.ArticleMapper;
import com.perfree.mapper.TagMapper;
import com.perfree.model.Article;
import com.perfree.model.ArticleTag;
import com.perfree.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private TagMapper tagMapper;

    /**
     * 添加文章
     * @param article 文章
     * @return ResponseBean
     */
    public ResponseBean add(Article article) {
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        Long articleId = articleMapper.add(article);
        // 处理新增的标签
        if (article.getAddTags() != null && article.getAddTags().size() > 0) {
            for (Tag tag :article.getAddTags()) {
                tag.setCreateTime(new Date());
                tag.setUpdateTime(new Date());
                tagMapper.add(tag);
                ArticleTag articleTag = new ArticleTag();
                articleTag.setTagId(tag.getId());
                article.getTags().add(articleTag);
            }
        }
        // 关联标签
        if (article.getTags() != null && article.getTags().size() > 0){
            for (ArticleTag tag : article.getTags()) {
                tag.setArticleId(articleId);
            }
            articleMapper.addTags(article.getTags());
        }
        if (articleId > 0){
            return new ResponseBean(200,"添加成功",articleId);
        }
        return new ResponseBean(500,"添加失败",null);
    }
}
