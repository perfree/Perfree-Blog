package com.perfree.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.perfree.common.Pager;
import com.perfree.mapper.UserMapper;
import com.perfree.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据账户获取用户信息
     * @param account 账户
     * @return User
     */
    public User getUserByAccount(String account) {
        return userMapper.getUserByAccount(account);
    }

    /**
     * 用户列表分页
     * @param pager pager
     * @return Pager<User>
     */
    public Pager<User> list(Pager<User> pager) {
        User user = pager.getForm();
        PageHelper.startPage(pager.getPageIndex(),pager.getPageSize());
        List<User> users = userMapper.list(user);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        pager.setCode(200);
        pager.setTotal(pageInfo.getTotal());
        pager.setData(pageInfo.getList());
        return pager;
    }
}
