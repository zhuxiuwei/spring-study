package com.xiuwei.demo02_静态代理;

/**
    缺点：只能代理UserService，没法代理ProductService. 原因感觉是以下几方面：
    1. 静态代理，需要和被代理类实现同样的接口（保证有同样的行为），因此换个接口就代理不了了。而动态代理通过反射，可以实现各种行为（接口方法）
    2. 静态代理，被代理的对象，也是个写死的field(本例的userService)。动态代理的Proxy.newInstance通过反射可以灵活制订被代理接口，InvokeHandler也可以
 */
public class UserServiceProxy implements UserService {

    private UserService userService;


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("add");
        userService.add();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void query() {
        log("query");
        userService.query();
    }

    //日志方法
    public void log(String msg){
        System.out.println("[debug] Use " + msg + " method!");
    }
}
