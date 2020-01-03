package com.grady.fim.mapper;

import com.grady.fim.common.pojo.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author gradyjiang
 * @Date 2020/1/3 - 下午12:12
 */
public interface RoleMapper {

    List<Role> getRolesByUserId(@Param("userId") Long userId);
}
