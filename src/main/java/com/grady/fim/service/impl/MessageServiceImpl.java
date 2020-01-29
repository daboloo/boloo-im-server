package com.grady.fim.service.impl;

import com.grady.fim.common.exception.BusinessException;
import com.grady.fim.common.pojo.req.P2PReqVo;
import com.grady.fim.mapper.MessageMapper;
import com.grady.fim.server.IMServer;
import com.grady.fim.server.exception.ChatException;
import com.grady.fim.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

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
            e.printStackTrace();
            throw new BusinessException(e.getCode(), e.getMsg());
        }
    }
}
