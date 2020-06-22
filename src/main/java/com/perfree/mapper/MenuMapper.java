package com.perfree.mapper;

import com.perfree.model.Menu;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MenuMapper {

    /**
     * 根据账户获取所拥有的菜单信息
     * @param account 账户
     * @return List<Menu>
     */
    List<Menu> getMenuByAccount(String account);

    /**
     * 菜单列表分页
     * @param menu 信息
     * @return List<Menu>
     */
    List<Menu> list(Menu menu);
}
