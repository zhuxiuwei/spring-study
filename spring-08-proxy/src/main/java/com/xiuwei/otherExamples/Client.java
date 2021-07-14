package com.xiuwei.otherExamples;

import com.xiuwei.demo02_静态代理.UserService;

import java.io.Serializable;
import java.lang.reflect.Proxy;

public class Client {
    public void test(){
        Account account = (Account) Proxy.newProxyInstance(getClass().getClassLoader(),
                new Class[] {Account.class, Serializable.class},    //！！！！因为Account接口没实现类，注意这里的写法！！！！   Serializable.class可以去掉。
                new ExampleInvocationHandler());

        // method chaining for the win!
        account.deposit(5000).deposit(4000).deposit(-2500);
        System.out.println(account);
        System.out.println("Balance: " + account.getBalance());
    }

    public static void main(String[] args) {
        new Client().test();
    }
}
