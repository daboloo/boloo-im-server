package com.grady.fim.common.pojo.rsp;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FriendListRspVo implements Serializable {


    private static final long serialVersionUID = -7779860614637718822L;

    private List<String> friends;
}
