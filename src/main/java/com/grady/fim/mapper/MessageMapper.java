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
     * 目标账户发送或接收的消息
     * @param username
     * @return
     */
    List<Message> selectMessageBy(@Param("username") String username);

    /**
     * 查询目标用户和他的目标好友的全部聊天记录
     * @param userAccount
     * @param friendAccount
     * @return
     */
    List<Message> selectMessageBind(@Param("userAccount") String userAccount, @Param("friendAccount") String friendAccount);

    /**
     * 确认消息已接收
     * @param userAccount
     * @param friendAccount
     */
    void verifyMsg(@Param("userAccount") String userAccount, @Param("friendAccount") String friendAccount);
}
