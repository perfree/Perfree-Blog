package com.perfree.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.perfree.common.Pager;
import com.perfree.mapper.RoleMapper;
import com.perfree.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 角色列表分页
     * @param pager page
     * @return Pager<Role>
     */
    public Pager<Role> list(Pager<Role> pager) {
        Role role = pager.getForm();
        PageHelper.startPage(pager.getPageIndex(),pager.getPageSize());
        List<Role> roles = roleMapper.list(role);
        PageInfo<Role> pageInfo = new PageInfo<>(roles);
        pager.setCode(200);
        pager.setTotal(pageInfo.getTotal());
        pager.setData(pageInfo.getList());
        return pager;
    }
}
