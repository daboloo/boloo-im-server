package com.grady.fim.service.impl;

import com.grady.fim.common.exception.BusinessException;
import com.grady.fim.common.pojo.bo.JsonResult;
import com.grady.fim.common.pojo.bo.UserSummaryBo;
import com.grady.fim.common.pojo.model.Message;
import com.grady.fim.common.pojo.req.P2PReqVo;
import com.grady.fim.common.pojo.rsp.ChatSummaryRspVo;
import com.grady.fim.common.utils.ResultTool;
import com.grady.fim.mapper.MessageMapper;
import com.grady.fim.server.IMServer;
import com.grady.fim.server.exception.ChatException;
import com.grady.fim.service.MessageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Log4j2
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;

    @Autowired
    private IMServer imServer;

    @Override
    public void sendMsg(@Valid P2PReqVo vo) throws BusinessException {
        messageMapper.recordP2PChat(vo);
        try {
            imServer.sendMsg(vo);
        } catch (ChatException e) {
            log.info("推送消息失败", e);
        }
    }

    @Override
    public JsonResult<ChatSummaryRspVo> getAllChatSummary(String userAccount) {
        List<Message> list = Optional.of(messageMapper.selectMessageBy(userAccount))
                .orElse(Collections.emptyList());

        List<UserSummaryBo> bos = handleMessages(list, userAccount);
        ChatSummaryRspVo rspVo = new ChatSummaryRspVo();
        rspVo.setList(bos);
        return ResultTool.success(rspVo);
    }

    /**
     * 获得 keyAccount 他的聊天好友的账户及最新的一条聊天信息
     * @param list
     * @param keyAccount
     * @return
     */
    private List<UserSummaryBo> handleMessages(List<Message> list, final String keyAccount) {
        List<UserSummaryBo> bos = new ArrayList<>();
        Map<String, List<Message>> msgMap = transformMap(list, keyAccount);
        msgMap.forEach((key, msgList) -> msgList.stream().max((Comparator.comparing(Message::getCreateTime)))
                .ifPresent(message -> {
                    UserSummaryBo bo = new UserSummaryBo();
                    bo.setLastMessage(message.getMessage());
                    bo.setUserAccount(key);
                    bo.setUnReadCount(getUnreadMsgCount(keyAccount, key));
                    bos.add(bo);
                })
        );
        return bos;
    }

    private int getUnreadMsgCount(String userAccount, String friendAccount) {
        return Optional.ofNullable(messageMapper.selectUnreadMsgCount(userAccount, friendAccount)).orElse(0);
    }

    private static Map<String, List<Message>> transformMap(List<Message> list, final String keyAccount) {
        return list.stream()
                .collect(Collectors.groupingBy(message -> {
                    String sendUserAccount = message.getSendUserAccount();
                    String acceptUserAccount = message.getAcceptUserAccount();
                    return sendUserAccount.equals(keyAccount) ? acceptUserAccount : sendUserAccount;
                }));
    }
}
