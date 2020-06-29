package com.perfree.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 附件
 */
public class Attach implements Serializable {
    /** 主键 */
    private Long id;
    /** 文件名 */
    private String fileName;
    /** 文件类型1:图片,2:视频,3:音乐,4:文本,5:其他 */
    private Integer fileType;
    /** 文件路径 */
    private String filePath;
    /** 创建时间 */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
