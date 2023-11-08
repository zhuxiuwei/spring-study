import anno_version1.AppConfig1;
import anno_version2.AppConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void testXml() {
        /**
         * 使用spring容器创建对象。获得Spring容器(ApplicationContext)
         * 代码里看不到new字眼了。
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        service.UserService userService = (service.UserServiceImpl) context.getBean("userServiceImpl");
        userService.getUser();
    }

    @Test
    public void testAnno1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig1.class);
        service.UserService userService = (service.UserServiceImpl) context.getBean("userServiceImpl");
        userService.getUser();
    }

    @Test
    public void testAnno2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig2.class);
        service.UserService userService = (anno_version2.service.UserServiceImpl) context.getBean("userServiceImpl");
        userService.getUser();
    }
}
