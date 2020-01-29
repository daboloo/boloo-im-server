package com.grady.fim.server.utils;

import com.grady.fim.server.pojo.res.MessageRepVo;
import com.grady.fim.server.pojo.res.WsContentRepVo;

public class WsRepUtil {

    public static WsContentRepVo createWsContentRepVo(Integer action, String senderId, String msg) {
        WsContentRepVo wsContentRepVo = new WsContentRepVo();
        wsContentRepVo.setAction(action);
        MessageRepVo messageRepVo = new MessageRepVo();
        messageRepVo.setSenderId(senderId);
        messageRepVo.setMsg(msg);
        wsContentRepVo.setChatMsg(messageRepVo);
        return wsContentRepVo;
    }
}
