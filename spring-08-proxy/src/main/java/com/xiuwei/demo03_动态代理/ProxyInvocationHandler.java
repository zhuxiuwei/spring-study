package com.xiuwei.demo03_动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//等候我们会用这个类自动生成代理（对比demo01.Proxy是手写的）
public class ProxyInvocationHandler implements InvocationHandler {

    //被代理的接口
    private Rent rent;

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    //生成得到的代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                rent.getClass().getInterfaces(), this);
    }

    //处理代理实例，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        seeHouse(); //附加操作
        //动态代理的本质，就是用反射实现！
        Object result = method.invoke(rent, args);  //实际的操作
        contract(); //附加操作
        return result;
    }

    //代理的附属操作 - 看房
    public void seeHouse(){
        System.out.println("中介带你看房");
    }

    //代理的附属操作 - 合同
    public void contract(){
        System.out.println("签租赁合同");
    }
}
