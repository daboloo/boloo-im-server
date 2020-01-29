package com.grady.fim.common.pojo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Message implements Serializable {

    private Long id;

    private String sendUserAccount;

    private String acceptUserAccount;

    private Integer acceptFlag;

    private String message;

    private Date createTime;
}
