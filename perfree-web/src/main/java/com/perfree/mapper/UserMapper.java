package com.perfree.mapper;

import com.perfree.model.User;
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
}
