package com.grady.fim.common.pojo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author gradyjiang
 * @Date 2020/1/3 - 下午1:00
 */
@Data
public class RolePermission implements Serializable {

    private Long id;

    /**
     * 权限url
     */
    private String url;

    /**
     * 权限名
     */
    private String name;
}
