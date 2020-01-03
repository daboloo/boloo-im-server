package com.grady.fim.common.pojo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author gradyjiang
 * @Date 2020/1/3 - 上午11:58
 */
@Data
public class Role implements Serializable {
    private Long id;
    private String name;
}
