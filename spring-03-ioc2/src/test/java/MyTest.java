import anno_version.MyConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;

public class MyTest {
    @Test
    public void xmlTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 默认：用无参构造
        User user = (User) context.getBean("user");
        user.show();

        // 构造函数方式1：通过参数下标赋值
        user = (User) context.getBean("user2");
        user.show();

        // 构造函数方式2：通过参数类型赋值。不建议使用，比如有两个string参数就不行了
        user = (User) context.getBean("user3");
        user.show();

        // 构造函数方式3：通过参数名赋值。作者建议用法，认为最直观!!!!!!!!!!!!!!!!!!
        user = (User) context.getBean("user4");
        user.show();

        //测试单例
        User user2 = (User) context.getBean("user4");
        System.out.println(user == user2);  //true
        /**
         * 输出：
         * 无参构造函数！
         * 有参构造函数！
         * 有参构造函数！
         * 有参构造函数！
         * name=Spring
         * name=通过参数下标赋值
         * name=通过参数类型赋值
         * name=通过参数名赋值
         * true
         *
         * 头4行， 说明在配置文件加载的时候（ApplicationContext创建好的时候），容器里的对象就被初始化了。
         * 最后一行，说明同一个id的bean实例化多次，还是同一个实例（单例模式）
         */
    }

    @Test
    public void annoTest(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        context.getBean("u1");
        context.getBean("u2");
//        context.getBean("user");  //不Work,会报错：org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'user' available
        /**
         * 输出：
         * 有参构造函数！
         * 无参构造函数！
         */
    }
}
