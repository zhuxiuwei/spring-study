package com.xiuwei.otherExamples;


import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 学习反射里 method相关用法
 */
public class Method反射用法 {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("com.xiuwei.otherExamples.ReflectTest");
        Object o = clazz.newInstance();
        Object o2 = clazz.newInstance();
        Method m1 = clazz.getDeclaredMethod("m1", null);
        m1.invoke(o, null); //m1

        Method m2_1 = clazz.getDeclaredMethod("m2", null);
        Object res = m2_1.invoke(o, null);  //m2 return 0      这里第一个参数传o2也行！！！
        System.out.println(res);    //0

        Method m2_2 = clazz.getDeclaredMethod("m2", int.class, int.class);  //注意后面几个参数 Class<?>... parameterTypes 的写法！！ （int.class第一次见。传Integer不行，会说找不到方法。）
        Object res2 = m2_2.invoke(o, 2, 3); //m2 return args sum: 2+3=5      注意args的传法！！
        System.out.println(res2);   //5

        System.out.println(int.class);  //int
        System.out.println(int.class.getClass().getName()); //java.lang.Class
        System.out.println(Arrays.toString(clazz.getInterfaces())); //[interface java.io.Serializable, interface java.lang.Runnable]
    }
}

class ReflectTest implements Serializable, Runnable{
    public void m1(){   //被反射的方法，需要时能access的，所以private不行
        System.out.println("m1");
    }

    public int m2(){
        System.out.println("m2 return 0");
        return 0;
    }

    public int m2(int i, int j ){
        int res = i + j;
        System.out.println("m2 return args sum: " + i + "+" + j + "=" + res);
        return res;
    }

    @Override
    public void run() {

    }
}
