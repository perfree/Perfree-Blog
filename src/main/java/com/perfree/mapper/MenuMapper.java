package com.perfree.mapper;

import com.perfree.model.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MenuMapper {

    /**
     * 根据账户获取所拥有的一级菜单信息
     * @param account 账户
     * @param type 类型
     * @return List<Menu>
     */
    List<Menu> getParentMenuByAccount(@Param("account") String account,@Param("type") int type);

    /**
     * 根据账户获取所拥有的子级菜单信息
     * @param account 账户
     * @param pid pid
     * @param type 类型
     * @return  List<Menu>
     */
    List<Menu> getChildMenuByAccount(@Param("account") String account, @Param("pid") Integer pid, @Param("type") int type);

    /**
     * 菜单列表分页
     * @param menu 信息
     * @return List<Menu>
     */
    List<Menu> list(Menu menu);

    /**
     * 添加菜单
     * @param menu 菜单
     * @return int
     */
    int add(Menu menu);

    /**
     * 删除子菜单
     * @param pid pid
     */
    void deleteChildMenu(Integer pid);

    /**
     * 删除菜单
     * @param id id
     */
    int deleteMenu(Integer id);

    /**
     * 更新状态
     * @param menu 菜单
     * @return int
     */
    int updateStatus(Menu menu);

    /**
     * 更新信息
     * @param menu 菜单
     * @return int
     */
    int update(Menu menu);
}
