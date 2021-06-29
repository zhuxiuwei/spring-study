import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;
import service.UserServiceImpl;

public class SpringTest {
    public static void main(String[] args) {
        /**
         * 使用spring容器创建对象。获得Spring容器(ApplicationContext)
         * 代码里看不到new字眼了。
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = (UserServiceImpl)context.getBean("userServiceImpl");
        userService.getUser();
    }
}
