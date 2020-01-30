package com.grady.fim.mapper;

import com.grady.fim.common.pojo.model.FriendRequest;
import org.apache.ibatis.annotations.Param;

public interface FriendRequestMapper {

    /**
     * 创建一条好友请求
     * @param request
     */
    void createRequest(FriendRequest request);

    /**
     * 查询好友请求
     * @param userAccount
     * @param friendAccount
     * @return
     */
    FriendRequest selectRequest(@Param("userAccount") String userAccount, @Param("friendAccount") String friendAccount);
}
