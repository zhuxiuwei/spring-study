import com.xiuwei.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    //测试AOP实现1： Spring 接口实现
    public void testAOP1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
        /*
         * [Before log] 执行了com.xiuwei.service.UserServiceMySQLImpl类的add方法，参数为：[]
         * add a user - MySQL
         * [After log] 执行了com.xiuwei.service.UserServiceMySQLImpl类的add方法，返回结果为：null
         */
        userService.update(3);
        /*
         * [Before log] 执行了com.xiuwei.service.UserServiceMySQLImpl类的update方法，参数为：[3]
         * update a user - MySQL
         * [After log] 执行了com.xiuwei.service.UserServiceMySQLImpl类的update方法，返回结果为：3
         */
        int i = userService.delete(3);
        /*
         * [Before log] 执行了com.xiuwei.service.UserServiceMySQLImpl类的delete方法，参数为：[3]
         * delete a user - MySQL
         * [DeleteMethodMoreWork] 执行清理动作。。。删除用户: 1
         * [After log] 执行了com.xiuwei.service.UserServiceMySQLImpl类的delete方法，返回结果为：1
         */
    }

    @Test
    //测试AOP实现2：自定义类
    public void testAOP2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_aop2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
        /*
         * ========方法执行前========
         * add a user - MySQL
         * ========方法执行后========
         */
        userService.update(3);
        /*
         * ========方法执行前========
         * update a user - MySQL
         * ========方法执行后========
         */
    }

    @Test
    //测试AOP实现3：注解方式实现AOP
    public void testAOP3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_aop3.xml");
        UserService userService = context.getBean("userService", UserService.class);
        try {
            userService.update(3);
        }catch (Exception e){   //会抛异常：org.springframework.aop.AopInvocationException: Null return value from advice does not match primitive return type for: public abstract int com.xiuwei.service.UserService.update(int) https://stackoverflow.com/questions/56497893/org-springframework-aop-aopinvocationexception-null-return-value-from-advice-do
//            e.printStackTrace();
        }
        /*
         * --------环绕前--------
         * ========方法执行前========
         * update a user - MySQL
         * Signature: int com.xiuwei.service.UserService.update(int)
         * args: [3]
         * Target: com.xiuwei.service.UserServiceMySQLImpl@1f0f1111
         * this: com.xiuwei.service.UserServiceMySQLImpl@1f0f1111
         * result: 3
         * --------环绕后--------
         * ========方法执行后========
         */
    }
}
