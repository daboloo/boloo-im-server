package com.grady.fim.service.impl;

import com.grady.fim.common.constants.ErrorCodes;
import com.grady.fim.common.exception.BusinessException;
import com.grady.fim.common.pojo.bo.JsonResult;
import com.grady.fim.common.pojo.model.Friend;
import com.grady.fim.common.pojo.model.FriendRequest;
import com.grady.fim.common.pojo.rsp.FriendListRspVo;
import com.grady.fim.common.pojo.rsp.NullBody;
import com.grady.fim.common.utils.ResultTool;
import com.grady.fim.mapper.FriendMapper;
import com.grady.fim.mapper.FriendRequestMapper;
import com.grady.fim.server.IMServer;
import com.grady.fim.server.exception.ChatException;
import com.grady.fim.service.FriendService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    FriendMapper friendMapper;

    @Autowired
    FriendRequestMapper friendRequestMapper;

    @Autowired
    IMServer imServer;

    @Override
    public JsonResult<FriendListRspVo> getFriendList(String username) {
        List<String> friendIds = Optional.ofNullable(friendMapper.selectFriendAccounts(username))
                .orElse(Collections.emptyList());
        FriendListRspVo rspVo = new FriendListRspVo();
        rspVo.setFriends(friendIds);
        return ResultTool.success(rspVo);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public JsonResult<NullBody> addFriendRequest(String userAccount, String friendAccount) throws BusinessException {
        checkAddFriendLegal(userAccount, friendAccount);

        FriendRequest friendRequest = new FriendRequest();
        friendRequest.setSendUserAccount(userAccount);
        friendRequest.setAcceptUserAccount(friendAccount);
        friendRequestMapper.createRequest(friendRequest);
        try {
            imServer.sendAddFriendRequest(friendRequest.getAcceptUserAccount());
        } catch (ChatException e) {
            log.info("推送好友请求失败", e);
        }

        return ResultTool.success(NullBody.create());
    }

    private void checkAddFriendLegal(String userAccount, String friendAccount) throws BusinessException {
        if (userAccount.equals(friendAccount)) {
            throw new BusinessException(ErrorCodes.ILLEGAL_ARGUMENT_CODE, "不能添加自己为好友");
        }
        Friend friend = friendMapper.selectFriendBy(userAccount, friendAccount);
        if (friend != null) {
            throw new BusinessException(ErrorCodes.ILLEGAL_ARGUMENT_CODE, friendAccount + "已是你的好友");
        }
        FriendRequest request = friendRequestMapper.selectRequest(userAccount, friendAccount);
        if (request != null) {
            throw new BusinessException(ErrorCodes.ILLEGAL_ARGUMENT_CODE, "重复发送" + friendAccount + "好友邀请");
        }
    }
}
