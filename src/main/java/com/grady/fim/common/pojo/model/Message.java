package com.grady.fim.common.pojo.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class Message implements Serializable {

    private static final long serialVersionUID = 3929385108489446003L;

    @Tolerate
    public Message() {}

    private Long id;

    private String sendUserAccount;

    private String acceptUserAccount;

    private Integer acceptFlag;

    private String message;

    private Date createTime;
}
