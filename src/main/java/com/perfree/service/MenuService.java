package com.perfree.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.perfree.common.Pager;
import com.perfree.mapper.MenuMapper;
import com.perfree.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuMapper menuMapper;

    /**
     * 根据账户获取所拥有的菜单信息
     * @param account 账户
     * @return List<Menu>
     */
    public List<Menu> getMenuByAccount(String account){
        return menuMapper.getMenuByAccount(account);
    }

    /**
     * 菜单列表分页
     * @param pager 分页信息
     * @return Pager<Menu>
     */
    public Pager<Menu> list(Pager<Menu> pager) {
        Menu menu = pager.getForm();
        PageHelper.startPage(pager.getPageIndex(), pager.getPageSize());
        List<Menu> menus = menuMapper.list(menu);
        PageInfo<Menu> pageInfo = new PageInfo<>(menus);
        pager.setCode(0);
        pager.setTotal(pageInfo.getTotal());
        pager.setData(pageInfo.getList());
        return pager;
    }
}
