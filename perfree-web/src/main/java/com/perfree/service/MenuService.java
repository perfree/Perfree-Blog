package com.perfree.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.perfree.common.Pager;
import com.perfree.common.ResponseBean;
import com.perfree.mapper.MenuMapper;
import com.perfree.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public List<Menu> getMenuByAccount(String account, int type){
        List<Menu> menus = menuMapper.getParentMenuByAccount(account, type);
        for (Menu menu:menus) {
            List<Menu> childMenus = menuMapper.getChildMenuByAccount(account, menu.getId(), type);
            menu.setChildMenu(childMenus);
        }
        return menus;
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

    /**
     * 添加菜单
     * @param menu 菜单信息
     * @return ResponseBean
     */
    public ResponseBean add(Menu menu) {
        menu.setSource(1);
        menu.setStatus(0);
        menu.setCreateTime(new Date());
        menu.setUpdateTime(new Date());
        int count = menuMapper.add(menu);
        if (count > 0){
            return new ResponseBean(200,"添加成功",null);
        }
        return new ResponseBean(500,"添加失败",null);
    }

    /**
     * 删除菜单
     * @param id id
     * @return ResponseBean
     */
    public ResponseBean deleteMenu(Integer id) {
        menuMapper.deleteChildMenu(id);
        int count = menuMapper.deleteMenu(id);
        if (count > 0) {
            return new ResponseBean(200, "删除成功", null);
        }
        return new ResponseBean(500,"删除失败",null);
    }

    /**
     * 更新状态
     * @param menu 菜单
     * @return ResponseBean
     */
    public ResponseBean updateStatus(Menu menu) {
        int count = menuMapper.updateStatus(menu);
        if (count > 0) {
            return new ResponseBean(200, "更新成功", null);
        }
        return new ResponseBean(500,"更新失败",null);
    }

    /**
     * 更新信息
     * @param menu 菜单
     * @return ResponseBean
     */
    public ResponseBean update(Menu menu) {
        menu.setUpdateTime(new Date());
        int count = menuMapper.update(menu);
        if (count > 0) {
            return new ResponseBean(200, "更新成功", null);
        }
        return new ResponseBean(500,"更新失败",null);
    }
}
