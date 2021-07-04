package com.xiuwei.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//等价于配置文件中：    <bean id="user" class="pojo.User"/>
@Component
//等价于配置文件中：    <bean id="user" class="pojo.User" scope="xxx"/>
@Scope("prototype")
public class User {

    //等价于配置文件中：    <property name="name" value="亚美爹"/>
    //也可以注入到setName方法上。
    @Value("亚美爹")
    private String name;

    public String getName() {
        return name;
    }

}
