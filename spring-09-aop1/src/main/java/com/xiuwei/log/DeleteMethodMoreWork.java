package com.xiuwei.log;

import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class DeleteMethodMoreWork implements AfterReturningAdvice {

    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("[DeleteMethodMoreWork] 执行清理动作。。。删除用户: " + o);
    }
}
