package com.grady.fim.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FriendMapper {

    /**
     * 根据账户名查询其好友的账户名
     * @param userAccount
     * @return
     */
    List<String> selectFriendIds(@Param("userAccount") String userAccount);
}
