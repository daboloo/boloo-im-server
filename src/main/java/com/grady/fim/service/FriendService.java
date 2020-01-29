package com.grady.fim.service;

import com.grady.fim.common.pojo.bo.JsonResult;
import com.grady.fim.common.pojo.rsp.FriendListRspVo;

public interface FriendService {

    /**
     * 根据用户名查询好友
     * @param username
     * @return
     */
    JsonResult<FriendListRspVo> getFriendList(String username);
}
