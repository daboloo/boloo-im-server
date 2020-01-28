package com.grady.fim.service.impl;

import com.grady.fim.common.pojo.bo.GrantedAuthorityBo;
import com.grady.fim.common.pojo.bo.UserDetailsBo;
import com.grady.fim.common.pojo.model.Role;
import com.grady.fim.common.pojo.model.User;
import com.grady.fim.mapper.RoleMapper;
import com.grady.fim.mapper.RolePermissionMapper;
import com.grady.fim.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * 参考 https://www.cnblogs.com/xifengxiaoma/p/11106220.html
 * @author gradyjiang
 * @Date 2020/1/3 - 上午11:52
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDetailsBo userDetailsBo = new UserDetailsBo();
        User user = Optional.ofNullable(userMapper.loadUserByUsername(userName))
                .orElseThrow(() -> new UsernameNotFoundException(userName + "不存在"));

        List<Role> roles = Optional.ofNullable(roleMapper.getRolesByUserId(user.getId())).orElse(Collections.emptyList());

        userDetailsBo.setUsername(user.getUsername());
        userDetailsBo.setPassword(user.getPassword());
        List<GrantedAuthorityBo> list = roles.stream().map(role -> rolePermissionMapper.getRolePermissions(role.getId()))
                .flatMap(Collection::stream)
                .map(permission -> new GrantedAuthorityBo(permission.getName()))
                .collect(toList());

        userDetailsBo.setAuthorities(list);
        return userDetailsBo;
    }
}
