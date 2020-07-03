package com.perfree.service;

import com.perfree.common.ResponseBean;
import com.perfree.mapper.ArticleMapper;
import com.perfree.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 添加文章
     * @param article 文章
     * @return ResponseBean
     */
    public ResponseBean add(Article article) {
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        int count = articleMapper.add(article);
        if (count > 0){
            return new ResponseBean(200,"添加成功",null);
        }
        return new ResponseBean(500,"添加失败",null);
    }
}
