package com.perfree.mapper;

import com.perfree.model.Role;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleMapper {

    /**
     * 角色列表分页
     * @param role role
     * @return Pager<Role>
     */
    List<Role> list(Role role);
}
