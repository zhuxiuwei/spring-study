import com.xiuwei.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    //测试AOP实现1： Spring 接口实现
    public static void testAOP1(){
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

    //测试AOP实现2：自定义类
    public static void testAOP2(){
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

    public static void main(String[] args) {
//        testAOP1();
        testAOP2();
    }
}
