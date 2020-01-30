package com.grady.fim.service;

import com.grady.fim.common.exception.BusinessException;
import com.grady.fim.common.pojo.bo.JsonResult;
import com.grady.fim.common.pojo.req.P2PReqVo;
import com.grady.fim.common.pojo.rsp.ChatMessageRspVo;
import com.grady.fim.common.pojo.rsp.ChatSummaryRspVo;
import com.grady.fim.common.pojo.rsp.UnreadMsgListRspVo;

public interface MessageService {

    /**
     * 一对一发送聊天数据
     * @param vo
     * @throws BusinessException
     */
    void sendMsg(P2PReqVo vo) throws BusinessException;

    /**
     * 获取聊天消息摘要
     * @param userAccount
     * @return
     */
    JsonResult<ChatSummaryRspVo> getAllChatSummary(String userAccount);

    /**
     * 获取聊天消息
     * @param userAccount
     * @param friendAccount
     * @return
     */
    JsonResult<ChatMessageRspVo> getMessages(String userAccount, String friendAccount);
}
