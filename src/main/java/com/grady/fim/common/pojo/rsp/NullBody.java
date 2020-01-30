package com.grady.fim.common.pojo.rsp;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NullBody implements Serializable {

    public NullBody() {}

    public static NullBody create(){
        return new NullBody();
    }
}
