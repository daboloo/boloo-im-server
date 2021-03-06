package com.grady.fim.common.pojo.req;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 一对一发送聊天实体
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class P2PReqVo implements Serializable {

    private static final long serialVersionUID = 7123355417384318083L;
    /**
     * 消息发送者的 userId
     */
    @NotNull(message = "userId 不能为空")
    private String userId ;


    /**
     * 消息接收者的 userId
     */
    @NotNull(message = "dstUserId 不能为空")
    private String dstUserId ;

    /**
     * 发送的消息
     */
    @NotNull(message = "msg 不能为空")
    private String msg ;

}
