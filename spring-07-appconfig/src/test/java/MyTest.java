import com.xiuwei.config.MyConfig;
import com.xiuwei.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        //AnnotationConfigApplicationContext： 配置类的ApplicationContext子类
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        /**
         * 根据配置类MyConfig获取Bean
         */
        //方法名getUser表示bean id，根据方法名获取bean（如果MyConfig类里getUser方法的@Bean注解没有加name值，才生效。否则报错：No bean named 'getUser' available）
//        User user5 = context.getBean("getUser", User.class);
//        System.out.println(user5); //报错：No bean named 'getUser' available
        //根据配置类里被覆盖的bean name获取 (MyConfig类: @Bean(name="haha"))
        User user1 = context.getBean("haha", User.class);
        System.out.println(user1);  //User{name='张三'}
        User user2 = context.getBean("haha", User.class);
        System.out.println(user2);  //User{name='张三'}
        System.out.println(user1 == user2);  //true

        /**
         * byType或byName获取。和MyConfig类无关（如果注释掉MyConfig里的"public User getUser()"方法，不影响下面user2的getBean执行。）
         * 能工作有2个前提：1). 配置类里加"@ComponentScan("com.xiuwei")" 2). User加Component注解。
         * 否则报错：Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'user' available
         */
        User user3 = context.getBean("user", User.class);
        User user4 = context.getBean("user", User.class);
        System.out.println(user3);  //User{name='张三'}
        System.out.println(user4);  //User{name='张三'}
        System.out.println(user3 == user4);  //true

        System.out.println(user1 == user3); //false。
        /**
         * Q: 为啥上面返回false呢？
         * A: MCopilot的解释：
         * user1和user3不相等。
         * 原因是user1和user3虽然都是User类型的Bean，但是他们是由不同的Bean定义创建的。
         * user1是由MyConfig类中的@Bean(name="haha")定义的Bean创建的，而user3是由User类上的@Component注解定义的Bean创建的。
         * 在Spring中，每一个Bean定义都会创建一个新的Bean实例，即使这些Bean的类型相同。所以，user1和user3是不同的实例。
         *
         * user1和user2是相等的，user3和user4也是相等的。
         * 原因是Spring框架默认的Bean作用域是单例模式（Singleton），也就是说在同一个Spring容器中，对于同一个Bean的定义，无论调用多少次getBean方法，都只会返回同一个Bean实例。
         * 在这段代码中，user1和user2都是通过同一个Bean定义（MyConfig类中的@Bean(name="haha")）获取的，所以他们是同一个实例。
         * 同理，user3和user4都是通过同一个Bean定义（User类上的@Component注解）获取的，所以他们也是同一个实例。
         */
    }
}
