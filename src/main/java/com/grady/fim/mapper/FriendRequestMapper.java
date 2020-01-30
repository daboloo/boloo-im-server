package com.grady.fim.mapper;

import com.grady.fim.common.pojo.model.FriendRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 查询 userAccount 的好友请求
     * @param userAccount
     * @return
     */
    List<FriendRequest> selectRequestByAccount(@Param("userAccount") String userAccount);

    /**
     * 删除好友请求
     * @param userAccount
     * @param friendAccount
     */
    void deleteRequest(@Param("userAccount") String userAccount, @Param("friendAccount") String friendAccount);
}
