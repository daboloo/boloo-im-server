package com.grady.fim.mapper;

import com.grady.fim.common.pojo.model.Message;
import com.grady.fim.common.pojo.req.P2PReqVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageMapper {

    /**
     * 写入聊天记录
     * @param vo
     */
    void recordP2PChat(P2PReqVo vo);

    /**
     * 根据用户名查询其未读消息数目
     * @param username
     * @return
     */
    Integer selectUnreadMsgCount(@Param("username") String username, @Param("sendAccount") String sendAccount);

    /**
     *
     * @param username
     * @return
     */
    List<Message> selectMessageBy(@Param("username") String username);
}
