package com.grady.fim.service;

import com.grady.fim.common.exception.BusinessException;
import com.grady.fim.common.pojo.bo.JsonResult;
import com.grady.fim.common.pojo.rsp.FriendListRspVo;
import com.grady.fim.common.pojo.rsp.NullBody;

public interface FriendService {

    /**
     * 根据用户名查询好友
     * @param username
     * @return
     */
    JsonResult<FriendListRspVo> getFriendList(String username);

    /**
     * 添加好友请求
     * @param userAccount
     * @param friendAccount
     * @return
     */
    JsonResult<NullBody> addFriendRequest(String userAccount, String friendAccount) throws BusinessException;
}
