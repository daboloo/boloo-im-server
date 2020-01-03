package com.grady.fim.mapper;

import com.grady.fim.common.pojo.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author gradyjiang
 * @Date 2020/1/3 - 下午12:45
 */
public interface UserMapper {

    User loadUserByUsername(@Param("username") String username);
}
