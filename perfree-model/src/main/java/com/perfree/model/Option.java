package com.perfree.model;

import java.util.Date;

/**
 * 配置表
 * @ClassName Option
 * @Author Majz
 * @Date 2020/7/1 11:37:15
 * @Version 1.0
 **/
public class Option {

    // 主键
    private Integer id;

    // 键
    private String key;

    // 值
    private String value;

    // 备注
    private String remark;

    // 类型
    private Integer type;

    // 创建时间
    private Date createTime;
    // 更新时间
    private Date updateTime;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
