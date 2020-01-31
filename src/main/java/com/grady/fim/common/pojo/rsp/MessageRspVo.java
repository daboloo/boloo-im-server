package com.grady.fim.common.pojo.rsp;

import com.grady.fim.common.pojo.model.Message;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MessageRspVo implements Serializable {

    private static final long serialVersionUID = -5555750563947740309L;


    private Long id;

    private String sendUserAccount;

    private String acceptUserAccount;

    private Integer acceptFlag;

    private String message;

    private Date createTime;

    private Boolean isMe = false;


    public static MessageRspVo transform(String meAccount, Message message) {
        MessageRspVo rspVo = new MessageRspVo();
        rspVo.setId(message.getId());
        rspVo.setSendUserAccount(message.getSendUserAccount());
        rspVo.setAcceptUserAccount(message.getAcceptUserAccount());
        rspVo.setAcceptFlag(message.getAcceptFlag());
        rspVo.setMessage(message.getMessage());
        rspVo.setCreateTime(message.getCreateTime());
        rspVo.setIsMe(meAccount.equals(message.getSendUserAccount()));
        return rspVo;
    }
}
