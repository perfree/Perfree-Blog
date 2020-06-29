package com.perfree.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 菜单表
 * @author Perfree
 */
public class Menu implements Serializable {
    // 主键
    private Integer id;
    // 菜单名
    private String menuName;
    // 菜单图标
    private String menuIcon;
    // 菜单路径
    private String menuPath;
    // 父菜单id，若为-1则为父菜单
    private Integer pid;
    // 序号
    private Integer seq;
    // 菜单标识0：后台，1：前台
    private Integer type;
    // 菜单打开方式
    private String target;
    // 创建时间
    private Date createTime;
    // 更新时间
    private Date updateTime;
    // 来源:0默认.1用户添加
    private Integer source;
    // 状态:0可用,1禁用
    private Integer status;

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    // 子菜单
    private List<Menu> childMenu;

    public List<Menu> getChildMenu() {
        return childMenu;
    }

    public void setChildMenu(List<Menu> childMenu) {
        this.childMenu = childMenu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer flag) {
        this.type = flag;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
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
