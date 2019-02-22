package com.hml.dubbo.customer;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by huml on 2018/12/19.
 */
public class A {

    @ApiModelProperty(value = "响应参数示例")
    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
