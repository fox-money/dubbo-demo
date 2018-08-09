package com.hml.dubbo.provider;

import com.hml.dubbo.api.DemoService;

/**
 * Created by huml on 2018/4/26.
 */
public class DemoServiceImpl implements DemoService {

    public void print(String str) {
        System.out.println(str);
    }
}
