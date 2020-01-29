package com.grady.fim.mapper;

import com.grady.fim.common.pojo.req.P2PReqVo;

public interface MessageMapper {

    /**
     * 写入聊天记录
     * @param vo
     */
    void recordP2PChat(P2PReqVo vo);
}
