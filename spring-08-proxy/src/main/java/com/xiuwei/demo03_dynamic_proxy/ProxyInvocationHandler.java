package com.xiuwei.demo03_dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//等候我们会用这个类自动生成代理（对比demo01.Proxy是手写的）
public class ProxyInvocationHandler implements InvocationHandler {

    //处理代理实例，并返回结果
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        return null;
    }
}
