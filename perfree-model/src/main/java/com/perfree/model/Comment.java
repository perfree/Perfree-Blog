package com.perfree.model;

import java.util.Date;
import java.util.List;

/**
 * 评论表
 * @ClassName Comment
 * @Author Majz
 * @Date 2020/7/1 9:35:25
 * @Version 1.0
 **/
public class Comment {

    // 主键
    private Long id;

    // 评论内容
    private String context;

    // 审核
    private Integer audit;

    // 创建时间
    private Date createTime;

    // 审核时间
    private Date auditTime;

    // 评论文章
    private Article article;

    // 评论人
    private User user;

    // 父级ID
    private Integer parentId;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    // 评论回复
    private List<Comment> childComment;

    public List<Comment> getChildComment() {
        return childComment;
    }

    public void setChildComment(List<Comment> childComment) {
        this.childComment = childComment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
