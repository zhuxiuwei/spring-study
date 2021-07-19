package com.xiuwei.service;

public class UserServiceMySQLImpl implements UserService{
    @Override
    public void add() {
        System.out.println("add a user - MySQL");
    }

    @Override
    public int delete(int userId) {
        System.out.println("delete a user - MySQL");
        return 1;
    }

    @Override
    public int update(int userId) {
        System.out.println("update a user - MySQL");
        return userId;
    }

    @Override
    public void query() {
        System.out.println("query a user - MySQL");
    }
}
