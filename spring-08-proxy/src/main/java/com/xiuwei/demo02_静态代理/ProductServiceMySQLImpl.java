package com.xiuwei.demo02_静态代理;

public class ProductServiceMySQLImpl implements ProductService{
    @Override
    public void add() {
        System.out.println("add a product - MySQL");
    }

    @Override
    public void delete() {
        System.out.println("delete a product - MySQL");
    }

    @Override
    public void update() {
        System.out.println("update a product - MySQL");
    }

    @Override
    public void query() {
        System.out.println("query a product - MySQL");
    }
}
