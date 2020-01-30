package com.grady.fim.mapper;

import com.grady.fim.common.pojo.model.Friend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FriendMapper {

    /**
     * 根据账户名查询其好友的账户名
     * @param userAccount
     * @return
     */
    List<String> selectFriendAccounts(@Param("userAccount") String userAccount);

    /**
     * 查询好友记录
     * @param userAccount
     * @param friendAccount
     * @return
     */
    Friend selectFriendBy(@Param("userAccount") String userAccount, @Param("friendAccount") String friendAccount);
}
