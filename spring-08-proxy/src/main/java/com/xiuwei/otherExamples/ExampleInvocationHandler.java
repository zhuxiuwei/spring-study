package com.xiuwei.otherExamples;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ExampleInvocationHandler implements InvocationHandler {
    private double balance;

    /**
     * 更多的用法！！！！
     * 看看怎么用proxy、method、args的，看看怎么返回的！！
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // simplified method checks, would need to check the parameter count and types too
        if ("deposit".equals(method.getName())) {
            Double value = (Double) args[0];
            System.out.println("deposit: " + value);
            balance += value;
//            System.out.println(Arrays.toString(proxy.getClass().getInterfaces()));  //[interface com.xiuwei.otherExamples.Account, interface java.io.Serializable]
//            System.out.println(proxy.getClass().getName()); //com.sun.proxy.$Proxy0
            return proxy; // ！！！！！！！ here we use the proxy to return 'this（com.xiuwei.otherExamples.Account）'。（直接返回this不对，this是ExampleInvocationHandler实例）
        }
        if ("getBalance".equals(method.getName())) {
            return balance;
        }
        return null;

    }
}