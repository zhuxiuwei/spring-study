package com.xiuwei.demo01_静态代理;

//租户
public class Client {
    public static void main(String[] args) {
        //房东要租房子
        Host host = new Host();
        
        //代理，帮房东出租房子，并有一些附属操作
        Proxy proxy = new Proxy(host);

        //租户不用面对房东，面对中介即可
        proxy.rent();
    }
}
