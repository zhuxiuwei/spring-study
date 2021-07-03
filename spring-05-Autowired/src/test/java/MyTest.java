import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Person;

//测试自动装配
public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = context.getBean("personByName", Person.class);
        person.getCat().shout();
        person.getDog().shout();

        person = context.getBean("personByType", Person.class);
        person.getCat().shout();
        person.getDog().shout();
    }
}
