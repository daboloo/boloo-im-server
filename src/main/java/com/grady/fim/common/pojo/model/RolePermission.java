package com.grady.fim.common.pojo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author gradyjiang
 * @Date 2020/1/3 - 下午1:00
 */
@Data
public class RolePermission implements Serializable {

    private String url;
    private String roleName;
}
