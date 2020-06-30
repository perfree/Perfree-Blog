package com.perfree.mapper;

import com.perfree.model.User;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    /**
     * 根据账户获取用户信息
     * @param account 账户
     * @return User
     */
    User getUserByAccount(String account);

    /**
     * 用户列表分页
     * @param user user
     * @return List<User>
     */
    List<User> list(User user);

    /**
     * 添加用户
     * @param user
     * @return
     */
    Long addUser(User user);

    /**
     * 添加用户与角色的关联关系
     * @param roleIds
     * @param userId
     * @return
     */
    Integer addUserAndRole(List<Integer> roleIds,Long userId);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    Integer updateUser(User user);

    /**
     * 根据用户Id查询
     * @param Id
     * @return
     */
    User getUser(Long Id);

    /**
     * 根据用户ID删除所有的角色关联信息
     * @param Id
     * @return
     */
    Integer delUserAndRole(Long Id);

    /**
     * 删除用户
     * @param id
     * @return
     */
    Integer deleteUser(Long id);

    /**
     * 更新状态
     * @param user
     * @return
     */
    Integer updateStatus(User user);
}
