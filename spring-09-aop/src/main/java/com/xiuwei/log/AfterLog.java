package com.xiuwei.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AfterLog implements AfterReturningAdvice {

    //returnValue： 返回值
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("[debug] 执行了"+ target.getClass().getName() + "类的" + method.getName() + "方法，返回结果为：" + returnValue);
    }
}
