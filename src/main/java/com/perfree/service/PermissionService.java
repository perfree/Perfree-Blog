package com.perfree.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.perfree.common.Pager;
import com.perfree.mapper.PermissionMapper;
import com.perfree.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 权限列表分页
     * @param pager page
     * @return Pager<Permission>
     */
    public Pager<Permission> list(Pager<Permission> pager) {
        Permission permission = pager.getForm();
        PageHelper.startPage(pager.getPageIndex(),pager.getPageSize());
        List<Permission> permissions = permissionMapper.list(permission);
        PageInfo<Permission> pageInfo = new PageInfo<>(permissions);
        pager.setCode(200);
        pager.setTotal(pageInfo.getTotal());
        pager.setData(pageInfo.getList());
        return pager;
    }
}
