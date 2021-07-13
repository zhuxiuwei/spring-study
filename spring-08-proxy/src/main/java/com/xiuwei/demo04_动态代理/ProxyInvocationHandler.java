package com.xiuwei.demo04_动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//InvocationHandler类： 调用处理程序，并返回一个结果
//作者这里想展示做一个“通用”的handler，所以target是Object类型。
public class ProxyInvocationHandler implements InvocationHandler {
    //被代理的接口(代理谁)
    private Object target;
    public void setTarget(Object target) {
        this.target = target;
    }

    //生成代理类。感觉这个可以在客户端写，不是一定要在InvocationHandler实现类里写。
    public Object getProxy(){
        //Proxy类：用户生成动态代理实例的
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),   //用哪个类加载器去加载代理对象。这里target改成this也work
                target.getClass().getInterfaces(),  //:动态代理类需要实现的接口
                this    //h:动态代理方法在执行时，会调用h里面的invoke方法去执行
        );
    }

    //代理、被代理方法的执行
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());  //附加代理动作
        Object result = method.invoke(target, args);
        return result;
    }

    //代理附加功能：日志方法
    public void log(String msg){
        System.out.println("[debug] Use " + msg + " method!");
    }
}
