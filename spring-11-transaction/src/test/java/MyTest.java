import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xiuwei.mapper.UserMapper;
import xiuwei.mapper.UserMapperImpl2;
import xiuwei.pojo.User;

public class MyTest {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = context.getBean("userMapper2", UserMapper.class);
        System.out.println(mapper.selectUser());    //[User(id=1, name=朱修伟, pwd=password), User(id=2, name=曹小娜, pwd=password)]

        User user = new User();
        user.setName("asdad");
        user.setPwd("1234");
        System.out.println(mapper.addUser(user));

//        System.out.println(mapper.deleteUser(3));
    }

    @Test
    //测试事务
    //如果事务生效，那么这个测试会报SQL语法错误的报错，同时db里没有插入新的user（数据一致性）。
    public void testTransaction(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = context.getBean("userMapper2", UserMapper.class);
        mapper.testTransactionMethod();
    }
}
