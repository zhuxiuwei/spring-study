import anno_version.AppConfigV1;
import anno_version.AppConfigV2;
import anno_version.pojo.Student2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Student;
import pojo.User;

public class MyTest {
    //各种属性注入测试 （9 各种类型属性的依赖注入）
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml") ;
        //getBean支持第二个参数，就不用强制类型转换了。 以下等同于：   Student student = (Student)context.getBean("student");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
        /**
         * 输出：
         * Student{name='top gun', address=Address{address='北京市海淀区'},
         *      books=["红楼梦", "西游记"], hobbies=["音乐", "电影"],
         *      card={身份证=身份照号码, 学生证=学生证号码}, games=["生化危机", "CS"],
         *      info={籍贯="USA", 性别="二椅子"}, wife='null'}
         */
    }

    //测试p标签和c标签注入 （10 C命名空间和p命名空间注入）
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user = (User)context.getBean("user");
        System.out.println(user);   //User{name='哈哈', age=18, nickName='null'}

        user = context.getBean("user2", User.class);
        System.out.println(user);   //User{name='hello', age=12, nickName='null'}

        user = context.getBean("mixPAndCUser", User.class);
        System.out.println(user);   //User{name='hello', age=13, nickName='昵称'}

    }
    @Test
    public void testAnnoV1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigV1.class);
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
        /**
         * 输出：
         * Student{name='top gun', address=Address{address='北京市海淀区222'},
         *      books=["红楼梦", "西游记"], hobbies=["音乐", "电影"],
         *      card={身份证=身份照号码, 学生证=学生证号码}, games=["生化危机", "CS"],
         *      info={籍贯="USA", 性别="二椅子"}, wife='null'}
         */

        Object address = context.getBean("address");
        System.out.println(address);
        /**
         * Address{address='北京市海淀区'}
         */
    }

    @Test
    public void testAnnoV2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigV2.class);
        Student2 student2 = context.getBean("student2", Student2.class);
        System.out.println(student2);

        Object address2 = context.getBean("address2");
        System.out.println(address2);

        /**
         * 输出：
         * Student{name='名字by注解', address2=Address2{address='空'}, books=null, hobbies=null, card=null, games=null, info=null, wife='null'}
         * Address2{address='空'}
         */
    }
}
