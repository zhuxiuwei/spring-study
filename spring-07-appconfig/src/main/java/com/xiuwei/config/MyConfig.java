package com.xiuwei.config;

import com.xiuwei.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration  //它本身也是个Component，所以也会被Spring托管注册到容器中。
// @Configuration 代表这是一个配置类，和之前的beans.xml一样。
@ComponentScan("com.xiuwei")
@Import(MyConfig2.class)    //合并2个配置文件，也类似xml的import标签
public class MyConfig {

    @Bean   //注册一个bean，相当于<bean>标签。
    public User getUser(){  //方法的名字 相当于bean ID； 方法的返回值，相当于bean class
        return new User();  //就是返回要注入的对象
    }
}
