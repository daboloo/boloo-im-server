package com.grady.fim.service.impl;

import com.grady.fim.common.pojo.bo.JsonResult;
import com.grady.fim.common.pojo.model.User;
import com.grady.fim.common.pojo.rsp.FriendListRspVo;
import com.grady.fim.common.utils.ResultTool;
import com.grady.fim.mapper.FriendMapper;
import com.grady.fim.mapper.UserMapper;
import com.grady.fim.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    FriendMapper friendMapper;

    @Override
    public JsonResult<FriendListRspVo> getFriendList(String username) {
        List<String> friendIds = Optional.ofNullable(friendMapper.selectFriendIds(username))
                .orElse(Collections.emptyList());
        FriendListRspVo rspVo = new FriendListRspVo();
        rspVo.setFriends(friendIds);
        return ResultTool.success(rspVo);
    }
}
