package com.xiuwei.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;

/**
 * 方式3： 注解方式实现AOP
 * 注解方式，需要每个方法都写一遍切入点，容易出错。作者因此个人更建议方式2（配置文件里配置的切入点可重用）
 */
@Aspect  //标注这个类 是一个切面！
public class AnnotationPointCut {
    
    @Before("execution(* com.xiuwei.service.UserService.*(..))")
    public void before(){
        System.out.println("========方法执行前========");
    }

    @After("execution(* com.xiuwei.service.UserService.*(..))")
    public void after(){
        System.out.println("========方法执行后========");
    }

    //在环绕增强中，我们可以给定一个参数，代表我们要获取处理切入的点
    //作者说这个方式不太常用，一般before after就够了
    @Around("execution(* com.xiuwei.service.UserService.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("--------环绕前--------");

        //执行方法
        Object result = joinPoint.proceed();

        //注意可以类似通过反射，从ProceedingJoinPoint获取执行中的一些方法信息！！！！
        //作者认为不是很常用，一般只用来打日志。
        System.out.println("Signature: " + joinPoint.getSignature());
        System.out.println("args: " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Target: " + joinPoint.getTarget());
        System.out.println("this: " + joinPoint.getThis());
        System.out.println("result: " + result);

        System.out.println("--------环绕后--------" );
    }
}
