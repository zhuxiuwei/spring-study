import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Student;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml") ;
        Student student = (Student)context.getBean("student");
        System.out.println(student);
    }

    /**
     * 输出：
     * Student{name='top gun', address=Address{address='北京市海淀区'},
     *      books=["红楼梦", "西游记"], hobbies=["音乐", "电影"],
     *      card={身份证=身份照号码, 学生证=学生证号码}, games=["生化危机", "CS"],
     *      info={籍贯="USA", 性别="二椅子"}, wife='null'}
     */
}
