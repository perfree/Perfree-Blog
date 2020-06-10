package com.perfree.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户表
 * @author Perfree
 */
public class User implements Serializable {
    // 主键
    private Long id;
    // 姓名
    private String name;
    // 登陆账户
    private String account;
    // 密码
    private String password;
    // 密码加密盐值
    private String salt;
    // 邮箱
    private String email;
    // 性别
    private Integer sex;
    // 年龄
    private Integer age;
    // 账户状态：0：正常，1：禁用
    private Integer status;
    // 创建时间
    private Date createTime;
    // 更新时间
    private Date updateTime;
    // 角色信息
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
