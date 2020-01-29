package com.grady.fim.common.pojo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Message implements Serializable {

    private String sendUserAccount;

    private String acceptUserAccount;

    private Integer acceptFlag;

    private String message;
}
