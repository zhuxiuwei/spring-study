package com.xiuwei.diy;

/**
 * AOP实现方式2 - 自定义类
 * 这个类 就是一个 切面(aspect)
 * 这个类 里的方法 就是 通知(advice)
 *
 * 没有Spring API接口方式 强大，因为Spring API接口 可以用反射实现更多功能（获取method、args、target等）
 * 是作者个人最建议的方式，因为 配置文件里的切入点 可复用（<aop:pointcut id="point" expression="execution(* com.xiuwei.service.UserService.*(..))"/>）
 * 而方式三 注解方式，需要每个方法都写一遍切入点，容易出错。
 */
public class DIYPointCut {
    public void before(){
        System.out.println("========方法执行前========");
    }

    public void after(){
        System.out.println("========方法执行后========");
    }
}
