package com.grady.fim.common.pojo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FriendRequest implements Serializable {

    private static final long serialVersionUID = -1264311907718423637L;

    private Long id;

    private String sendUserAccount;

    private String acceptUserAccount;

    private Date createTime;
}
