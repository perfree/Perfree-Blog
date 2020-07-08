package com.perfree.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.perfree.common.Pager;
import com.perfree.common.ResponseBean;
import com.perfree.mapper.ArticleMapper;
import com.perfree.mapper.TagMapper;
import com.perfree.model.Article;
import com.perfree.model.ArticleTag;
import com.perfree.model.Tag;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
        if (StringUtils.isNotBlank(article.getPassword())){
            article.setPassword(new SimpleHash("MD5", article.getPassword()).toString());
        }
        Long articleId = articleMapper.add(article);
        articleTagHandle(article);
        if (articleId > 0){
            return new ResponseBean(200,"添加成功",articleId);
        }
        return new ResponseBean(500,"添加失败",null);
    }

    /**
     * 文章列表
     * @param pager 分页
     * @return   Pager<Article>
     */
    public Pager<Article> list(Pager<Article> pager) {
        Article article = pager.getForm();
        PageHelper.startPage(pager.getPageIndex(), pager.getPageSize());
        List<Article> articles = articleMapper.list(article);
        PageInfo<Article> pageInfo = new PageInfo<>(articles);
        pager.setCode(0);
        pager.setTotal(pageInfo.getTotal());
        pager.setData(pageInfo.getList());
        return pager;
    }

    /**
     * 删除文章
     * @param id 文章id
     * @return ResponseBean
     */
    public ResponseBean delete(Long id) {
        int count = articleMapper.delete(id);
        articleMapper.deleteArticleTag(id);
        if (count > 0) {
            return new ResponseBean(200, "删除成功", null);
        }
        return new ResponseBean(500,"删除失败",null);
    }

    /**
     * 根据文章id获取数据
     * @param id id
     * @return ResponseBean
     */
    public ResponseBean getArticleById(Long id) {
        return new ResponseBean(200, "获取成功", articleMapper.getArticleById(id));
    }

    /**
     * 更新文章
     * @param article 文章数据
     * @return ResponseBean
     */
    public ResponseBean update(Article article) {
        article.setUpdateTime(new Date());
        // 更新文章
        int count = articleMapper.update(article);
        // 删除关联的标签
        articleMapper.deleteArticleTag(article.getId());
        // 处理新增的标签
        articleTagHandle(article);
        if (count > 0){
            return new ResponseBean(200,"更新成功",article);
        }
        return new ResponseBean(500,"更新失败",null);
    }

    /**
     * 文章标签处理
     * @param article 文章
     */
    public void articleTagHandle(Article article){
        // 处理新增的标签
        if (article.getTags() != null && article.getTags().size() > 0) {
            for (Tag tag :article.getTags()) {
                tag.setCreateTime(new Date());
                tag.setUpdateTime(new Date());
                tagMapper.add(tag);
                ArticleTag articleTag = new ArticleTag();
                articleTag.setTagId(tag.getId());
                article.getArticleTags().add(articleTag);
            }
        }
        // 关联标签
        if (article.getArticleTags() != null && article.getArticleTags().size() > 0){
            for (ArticleTag tag : article.getArticleTags()) {
                tag.setArticleId(article.getId());
            }
            articleMapper.addTags(article.getArticleTags());
        }
    }
}
