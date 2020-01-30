package com.grady.fim.common.pojo.rsp;

import com.grady.fim.common.pojo.model.User;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FriendRequestRspVo implements Serializable {

    private static final long serialVersionUID = -5735018302294716186L;

    List<User> preFriend;
}
