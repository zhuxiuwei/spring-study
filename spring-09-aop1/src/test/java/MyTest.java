import com.xiuwei.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
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
}
