package com.grady.fim.common.pojo.bo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserSummaryBo implements Serializable {

    private static final long serialVersionUID = 4859096305655627021L;

    private String userAccount;

    private String lastMessage;

    private Integer unReadCount;
}
