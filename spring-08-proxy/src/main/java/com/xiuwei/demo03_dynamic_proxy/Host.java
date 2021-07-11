package com.xiuwei.demo03_dynamic_proxy;

import com.xiuwei.demo01.Rent;

//房东
public class Host implements Rent {
    @Override
    public void rent() {
        System.out.println("房东要出租房子");
    }
}
