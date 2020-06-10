package com.perfree.service;

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
}
