import anno_version.MyConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Person;

//测试自动装配
public class MyTest {
    @Test
    public void testXml(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = context.getBean("personByName", Person.class);
        person.getCat().shout();
        person.getDog().shout();

        person = context.getBean("personByType", Person.class);
        person.getCat().shout();
        person.getDog().shout();
    }

    @Test
    public void testAnno(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Person person = context.getBean("person", Person.class);
        person.getCat().shout();
        person.getDog().shout();
    }
}
