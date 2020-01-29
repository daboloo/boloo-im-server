package com.grady.fim.mapper;

import com.grady.fim.common.pojo.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author gradyjiang
 * @Date 2020/1/3 - 下午12:45
 */
public interface UserMapper {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User loadUserByUsername(@Param("username") String username);

    /**
     * 新建用户
     * @param username
     * @param password
     */
    void createUser(@Param("username") String username, @Param("password") String password);
}
