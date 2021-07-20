package com.xiuwei.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * AOP实现方式1 - Spring接口
 */
public class BeforeLog implements MethodBeforeAdvice {

    @Override
    /***
     * method: 要执行的目标对象的方法
     * args: 参数
     * target: 目标对象
     */
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("[Before log] 执行了"+ target.getClass().getName() + "类的" + method.getName() + "方法，参数为：" + Arrays.toString(args));
    }
}
