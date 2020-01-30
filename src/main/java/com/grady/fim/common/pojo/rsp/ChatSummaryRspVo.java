package com.grady.fim.common.pojo.rsp;

import com.grady.fim.common.pojo.bo.UserSummaryBo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ChatSummaryRspVo implements Serializable {

    private static final long serialVersionUID = 4936085311511061672L;

    private List<UserSummaryBo> list;
}
