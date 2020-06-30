package com.perfree.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.perfree.common.Pager;
import com.perfree.common.ResponseBean;
import com.perfree.mapper.RoleMapper;
import com.perfree.mapper.UserMapper;
import com.perfree.model.Role;
import com.perfree.model.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.provider.MD5;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService{

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

    /**
     * 添加用户
     * @param user
     * @return
     */
    public ResponseBean addUser(User user){
        User userByName = userMapper.getUserByAccount(user.getAccount());
        if(userByName != null) {
            return new ResponseBean(500,"账号已存在",null);
        }
        List<Role> roles = user.getRoles();
        String salt = UUID.randomUUID().toString().replaceAll("-","");
        String pwd = new SimpleHash("MD5", user.getPassword(), salt, 1024).toString();
        user.setSalt(salt);
        user.setPassword(pwd);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        Long userId = userMapper.addUser(user);
        if(userId == 0 || user.getId() == null) {
            return new ResponseBean(500,"添加失败",null);
        }
        /**
         * 添加用户与角色关联信息
         */
        List<Integer> roleIds = roles.stream().map(e -> e.getId()).collect(Collectors.toList());
        Integer count =  userMapper.addUserAndRole(roleIds,user.getId());
        if(count > 0) {
            return new ResponseBean(200,"添加成功",null);
        }else {
            return new ResponseBean(500,"添加失败",null);
        }
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public ResponseBean updateUser(User user){
        // 判断用户的密码是否做了修改
        if(StringUtils.isNotBlank(user.getPassword())) {
            String salt = UUID.randomUUID().toString().replaceAll("-","");
            String pwd = new SimpleHash("MD5", user.getPassword(), salt, 1024).toString();
            user.setSalt(salt);
            user.setPassword(pwd);
        }
        user.setUpdateTime(new Date());
        int count = userMapper.updateUser(user);
        if (count == 0) {
            return new ResponseBean(500,"更新失败",null);
        }
        count = userMapper.delUserAndRole(user.getId());
        if (count == 0) {
            return new ResponseBean(500,"更新失败",null);
        }
        List<Role> roles = user.getRoles();
        List<Integer> roleIds = roles.stream().map(e -> e.getId()).collect(Collectors.toList());
        count = userMapper.addUserAndRole(roleIds,user.getId());
        if (count == 0) {
            return new ResponseBean(500,"更新失败",null);
        } else {
            return new ResponseBean(200,"更新成功",null);
        }
    }

    /**
     * 修改用户状态
     * @param user
     * @return
     */
    public ResponseBean updateStatus(User user) {
        int count = userMapper.updateStatus(user);
        if (count == 0) {
            return new ResponseBean(500,"更新失败",null);
        }else{
            return new ResponseBean(200,"更新成功",null);
        }
    }

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    public ResponseBean deleteUser(Long id, User loginUser) {
        User userById = userMapper.getUser(id);
        if(userById.getAccount().equals(loginUser.getAccount())){
            return new ResponseBean(500,"删除失败",null);
        }
        int count = userMapper.deleteUser(id);
        if (count == 0) {
            return new ResponseBean(500,"删除失败",null);
        }else{
            return new ResponseBean(200,"删除成功",null);
        }
    }
}
