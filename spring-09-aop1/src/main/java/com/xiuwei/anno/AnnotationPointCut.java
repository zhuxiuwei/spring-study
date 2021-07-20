package com.xiuwei.anno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 方式3： 注解方式实现AOP
 */
@Aspect  //标注这个类 是一个切面！
public class AnnotationPointCut {
    
    @Before("execution(com.xiuwei.service.UserService.*(..)")
    public void before(){
        System.out.println("========方法执行前========");
    }

    public void after(){
        System.out.println("========方法执行后========");
    }
}
