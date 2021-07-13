package com.xiuwei.demo02_静态代理;

//缺点：只能代理UserService，没法代理ProductService
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
