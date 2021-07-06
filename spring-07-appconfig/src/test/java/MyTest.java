import com.xiuwei.config.MyConfig;
import com.xiuwei.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        User user = context.getBean("getUser", User.class);     //根据配置类MyConfig里方法名getUser表示bean id，获取bean
        User user2 = context.getBean("user", User.class);   //能工作有2个前提：1). 配置类里加"@ComponentScan("com.xiuwei")" 2). User加Component注解。
        System.out.println(user);
        System.out.println(user2);
        System.out.println(user == user2);  //false
    }
}
