import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Hello;

public class MyTest {
    public static void main(String[] args) {
        //代码拷贝自：https://docs.spring.io/spring-framework/docs/5.2.0.RELEASE/spring-framework-reference/core.html#beans-factory-instantiation
        //提供给ApplicationContext构造函数的一个或多个位置路径是资源字符串，允许容器从各种外部资源（例如本地文件系统、Java 等）加载配置元数据CLASSPATH。
        /**
         * 获取spring的上下文对象。
         */
        ApplicationContext context = new ClassPathXmlApplicationContext( "beans.xml");
        /**
         * 我们的对象都在spring中管理，要使用时，直接从里面取出来即可。
         */
        Hello hello = (Hello) context.getBean("hello");
        hello.show();
    }
}

