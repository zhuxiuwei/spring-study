import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xiuwei.mapper.UserMapper;

public class MyTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = context.getBean("userMapper", UserMapper.class);
        System.out.println(mapper.selectUser());    //[User(id=1, name=朱修伟, pwd=password), User(id=2, name=曹小娜, pwd=password)]
    }

    @Test
    //测试使用SqlSessionDaoSupport，进一步简化。（了解即可）
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = context.getBean("userMapper2", UserMapper.class);
        System.out.println(mapper.selectUser());    //[User(id=1, name=朱修伟, pwd=password), User(id=2, name=曹小娜, pwd=password)]
    }
}
