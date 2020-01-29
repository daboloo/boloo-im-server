package com.grady.fim.common.pojo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Friend implements Serializable {

    private static final long serialVersionUID = 8454887552839222380L;

    private Long id;

    private String userAccount;

    private String friendUserAccount;
}
