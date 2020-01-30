package com.grady.fim.service.impl;

import com.grady.fim.common.exception.BusinessException;
import com.grady.fim.common.pojo.bo.JsonResult;
import com.grady.fim.common.pojo.model.Message;
import com.grady.fim.common.pojo.req.P2PReqVo;
import com.grady.fim.common.pojo.rsp.UnreadMsgListRspVo;
import com.grady.fim.common.utils.ResultTool;
import com.grady.fim.mapper.MessageMapper;
import com.grady.fim.server.IMServer;
import com.grady.fim.server.exception.ChatException;
import com.grady.fim.service.MessageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
    public JsonResult<UnreadMsgListRspVo> getUnreadMsg(String username) {
        List<Message> messageList = Optional.ofNullable(messageMapper.selectUnreadMsg(username))
                .orElse(Collections.emptyList());

        Map<String, List<Message>> map = messageList.stream()
                .collect(Collectors.groupingBy(Message::getSendUserAccount));
        UnreadMsgListRspVo repVo = new UnreadMsgListRspVo();
        repVo.setMessages(map);
        return ResultTool.success(repVo);
    }
}
