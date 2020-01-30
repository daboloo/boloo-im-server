package com.grady.fim.common.pojo.rsp;

import com.grady.fim.common.pojo.model.Message;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ChatMessageRspVo implements Serializable {

    private static final long serialVersionUID = -4122010426254737256L;

    private List<Message> list;
}
