package com.grady.fim.service.impl;

import com.grady.fim.common.exception.BusinessException;
import com.grady.fim.common.pojo.req.P2PReqVo;
import com.grady.fim.mapper.MessageMapper;
import com.grady.fim.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;

    @Override
    public void sendMsg(@Valid P2PReqVo vo) throws BusinessException {
        messageMapper.recordP2PChat(vo);
        //TODO: 通过WebSocket 发送到节点
    }
}
