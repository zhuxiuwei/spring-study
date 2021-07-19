import com.xiuwei.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add(); //[Before log] 执行了com.xiuwei.service.UserServiceMySQLImpl类的add方法，参数为：[] \n add a user - MySQL \n[After log] 执行了com.xiuwei.service.UserServiceMySQLImpl类的add方法，返回结果为：null
        int i = userService.delete(3);  //[Before log] 执行了com.xiuwei.service.UserServiceMySQLImpl类的delete方法，参数为：[3] \n delete a user - MySQL \n [After log] 执行了com.xiuwei.service.UserServiceMySQLImpl类的delete方法，返回结果为：1
    }
}
