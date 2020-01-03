package com.grady.fim.common.pojo.bo;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author gradyjiang
 * @Date 2020/1/3 - 下午12:01
 */
public class GrantedAuthorityBo implements GrantedAuthority {

    private String authority;

    public GrantedAuthorityBo(String name) {
        this.authority = name;
    }


    @Override
    public String getAuthority() {
        return authority;
    }
}
