package com.xiuwei.demo02_静态代理;

public class UserServiceOracleImpl implements UserService{
    @Override
    public void add() {
        System.out.println("add a user - Oracle");
    }

    @Override
    public void delete() {
        System.out.println("delete a user - Oracle");
    }

    @Override
    public void update() {
        System.out.println("update a user - Oracle");
    }

    @Override
    public void query() {
        System.out.println("query a user - Oracle");
    }
}
