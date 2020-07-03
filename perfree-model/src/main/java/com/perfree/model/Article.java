package com.perfree.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章
 */
public class Article implements Serializable {
    /** 主键 */
    private Long id;
    /** 文章标题 */
    private String articleTitle;
    /** 文章内容 */
    private String articleContent;
    /** 文章状态0:正常,1:隐藏,2:置顶 */
    private Integer status;
    /** 文章缩略图,对应附件Id */
    private Long thumbnailId;
    /** 文章描述/摘要 */
    private String articleSummary;
    /** 缩略图类型:0:随机,1:大图,2:小图 */
    private Integer thumbnailType;
    /** 所属分类 */
    private Integer categoryId;
    /** 发表人 */
    private Long userId;
    /** 浏览量 */
    private Long viewCount;
    /** 是否加密0:不加密,1:加密,3:草稿 */
    private Integer isEncrypt;
    /** 密码 */
    private String password;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
    /** 关键字 */
    private String keyword;
    /** 是否允许评论:0允许,1不允许 */
    private Integer isAllowComment;

    public Integer getIsAllowComment() {
        return isAllowComment;
    }

    public void setIsAllowComment(Integer isAllowComment) {
        this.isAllowComment = isAllowComment;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getThumbnailId() {
        return thumbnailId;
    }

    public void setThumbnailId(Long thumbnailId) {
        this.thumbnailId = thumbnailId;
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }

    public Integer getThumbnailType() {
        return thumbnailType;
    }

    public void setThumbnailType(Integer thumbnailType) {
        this.thumbnailType = thumbnailType;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getIsEncrypt() {
        return isEncrypt;
    }

    public void setIsEncrypt(Integer isEncrypt) {
        this.isEncrypt = isEncrypt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
