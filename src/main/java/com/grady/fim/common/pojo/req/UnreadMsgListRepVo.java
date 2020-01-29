package com.grady.fim.common.pojo.req;

import com.grady.fim.common.pojo.model.Message;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 未读消息实体
 */
@Data
public class UnreadMsgListRepVo implements Serializable {
    private static final long serialVersionUID = 7258525220656828011L;

    Map<String, List<Message>> messages;
}
