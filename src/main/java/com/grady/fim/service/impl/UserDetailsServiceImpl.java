package com.grady.fim.service.impl;

import com.grady.fim.common.pojo.bo.GrantedAuthorityBo;
import com.grady.fim.common.pojo.bo.UserDetailsBo;
import com.grady.fim.common.pojo.model.Role;
import com.grady.fim.common.pojo.model.User;
import com.grady.fim.mapper.RoleMapper;
import com.grady.fim.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * @author gradyjiang
 * @Date 2020/1/3 - 上午11:52
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDetailsBo userDetailsBo = new UserDetailsBo();
        User user = userMapper.loadUserByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException(userName + "不存在");
        }
        List<Role> roles = Optional.ofNullable(roleMapper.getRolesByUserId(user.getId())).orElse(Collections.emptyList());

        userDetailsBo.setUsername(user.getUsername());
        userDetailsBo.setPassword(user.getPassword());
        userDetailsBo.setAuthorities(roles.stream().map(role -> new GrantedAuthorityBo(role.getName())).collect(toList()));
        return userDetailsBo;
    }
}
