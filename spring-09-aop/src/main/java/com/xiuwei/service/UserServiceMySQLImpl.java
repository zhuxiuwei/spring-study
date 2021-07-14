package com.xiuwei.service;

public class UserServiceMySQLImpl implements UserService{
    @Override
    public void add() {
        System.out.println("add a user - MySQL");
    }

    @Override
    public void delete() {
        System.out.println("delete a user - MySQL");
    }

    @Override
    public void update() {
        System.out.println("update a user - MySQL");
    }

    @Override
    public void query() {
        System.out.println("query a user - MySQL");
    }
}
