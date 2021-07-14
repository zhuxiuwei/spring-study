package com.xiuwei.demo04_动态代理;

import com.xiuwei.demo02_静态代理.ProductService;
import com.xiuwei.demo02_静态代理.ProductServiceMySQLImpl;
import com.xiuwei.demo02_静态代理.UserService;
import com.xiuwei.demo02_静态代理.UserServiceMySQLImpl;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        //真实角色
        UserService userService = new UserServiceMySQLImpl();
        //代理处理类
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        handler.setTarget(userService);     //设置要代理的对象
        //动态生成代理类
        UserService proxy = (UserService) handler.getProxy();
        //通过代理 执行方法
        proxy.add();    //[debug] Use add method! \n add a user - Oracle
        proxy.delete(); //[debug] Use delete method! \n delete a user - Oracle

        //在这里生成代理类也可以吧。试试。
        UserService proxy2 = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                handler
        );
        proxy2.query(); //[debug] Use query method!  query a user - Oracle

        /** 优点！！！！  不只能代理userService，还能代理productService! **/
        //真实角色
        ProductService productService = new ProductServiceMySQLImpl();
        handler.setTarget(productService);     //设置要代理的对象
        //生成代理类
        ProductService proxy3 = (ProductService) handler.getProxy();
        //通过代理 执行方法
        proxy3.add();   //[debug] Use add method! \n add a product - MySQL
    }
}
