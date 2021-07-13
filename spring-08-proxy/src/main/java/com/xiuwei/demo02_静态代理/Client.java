package com.xiuwei.demo02_静态代理;

public class Client {
    public static void main(String[] args) {
        //实际的类
        UserService userServiceMySQL = new UserServiceMySQLImpl();
        UserService userServiceOracle = new UserServiceOracleImpl();

        //代理类
        UserServiceProxy proxy = new UserServiceProxy();

        //代理类设置实际类
        proxy.setUserService(userServiceMySQL);
//        proxy.setUserService(userServiceOracle);

        //通过代理类执行
        proxy.add();
    }
}
