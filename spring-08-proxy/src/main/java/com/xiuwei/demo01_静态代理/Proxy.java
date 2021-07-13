package com.xiuwei.demo01_静态代理;

public class Proxy implements Rent{
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        seeHouse();
        host.rent();
        contract();
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
