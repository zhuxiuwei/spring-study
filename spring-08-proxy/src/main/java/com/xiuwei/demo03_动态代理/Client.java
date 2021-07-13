package com.xiuwei.demo03_动态代理;

import java.util.Properties;

public class Client {
    public static void main(String[] args) {
        //真实角色
        Host host = new Host();

        //代理角色：现在没有。
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        //通过调用handler，来处理我们要调用的接口对象！
        handler.setRent(host);
        Rent proxy = (Rent) handler.getProxy(); //这里的代理就是动态生成的
        proxy.rent();

    }
}
