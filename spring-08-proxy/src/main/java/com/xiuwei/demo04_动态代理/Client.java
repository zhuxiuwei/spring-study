package com.xiuwei.demo04_动态代理;

import com.xiuwei.demo02_静态代理.UserService;
import com.xiuwei.demo02_静态代理.UserServiceImpl;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        //真实角色
        UserService userService = new UserServiceImpl();
        //代理处理类
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        handler.setTarget(userService);     //设置要代理的对象
        //动态生成代理类
        UserService proxy = (UserService) handler.getProxy();
        //通过代理 执行方法
        proxy.add();
        proxy.delete();

        //在这里生成代理类也可以吧。试试。
        UserService proxy2 = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                handler
            );
        proxy2.query();
    }
}
