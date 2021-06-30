import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Student;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml") ;
        Student student = (Student)context.getBean("student");
        System.out.println(student);
        System.out.println(student.getAddress());
    }
}
