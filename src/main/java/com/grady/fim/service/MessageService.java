package com.grady.fim.service;

import com.grady.fim.common.exception.BusinessException;
import com.grady.fim.common.pojo.bo.JsonResult;
import com.grady.fim.common.pojo.req.P2PReqVo;
import com.grady.fim.common.pojo.rsp.UnreadMsgListRepVo;

public interface MessageService {

    /**
     * 一对一发送聊天数据
     * @param vo
     * @throws BusinessException
     */
    void sendMsg(P2PReqVo vo) throws BusinessException;

    JsonResult<UnreadMsgListRepVo> getUnreadMsg(String username);

}
