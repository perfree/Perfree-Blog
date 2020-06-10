package com.perfree.mapper;

import com.perfree.model.Permission;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PermissionMapper {

    /**
     * 权限列表分页
     * @param permission permission
     * @return Pager<Permission>
     */
    List<Permission> list(Permission permission);
}
