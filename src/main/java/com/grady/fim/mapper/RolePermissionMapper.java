package com.grady.fim.mapper;

import com.grady.fim.common.pojo.model.RolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author gradyjiang
 * @Date 2020/1/3 - 下午1:02
 */
public interface RolePermissionMapper {

    List<RolePermission> getRolePermissions(@Param("roleId") Long roleId);
}
