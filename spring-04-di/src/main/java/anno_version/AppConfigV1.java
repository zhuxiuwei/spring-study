package anno_version;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pojo.Address;
import pojo.Student;
import java.util.*;

/**
 * @Bean注解版。美团MC自动生成。231107
 */
@Configuration
public class AppConfigV1 {

    @Bean
    public Address address222() {
        Address address = new Address();
        address.setAddress("北京市海淀区222");
        return address;
    }

    @Bean
    public Address address() {
        Address address = new Address();
        address.setAddress("北京市海淀区");
        return address;
    }

    /**
     * @Bean修饰方法的参数的自动注入：
        https://blog.csdn.net/u014486725/article/details/122711602:
        ————————————————
        在日常开发中使用做多的是通过@Autowired的方式注入属性。
        下面介绍一种不太常用的，在方法参数中注入spring管理的bean方式，如下：
         @Configuration
         public class DruidConfig
         {
             @Bean
             @ConfigurationProperties("spring.datasource.druid.master")
             public DataSource masterDataSource(DruidProperties druidProperties)
             {
                DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
                return druidProperties.dataSource(dataSource);
             }
         }
         需要注意两点;
         1、方法需要使用@Bean或者@Autowired注解。
         2、方法中参数需要是spring管理的bean，比如上例中的druidProperties。
        ————————————————
     *
     * 注意@Qualifier，当有多个Address组件时，用@Qualifier来byName地指定用哪个
     * */
    @Bean
    public Student student(@Qualifier("address222")Address address) {
        Student student = new Student();
        student.setName("top gun");
        student.setBooks(new String[]{"红楼梦", "西游记"});
        student.setHobbies(Arrays.asList("音乐", "电影"));

        Map<String, String> card = new HashMap<String, String>();
        card.put("身份证", "身份照号码");
        card.put("学生证", "学生证号码");
        student.setCard(card);

        Set<String> games = new HashSet<String>();
        games.add("生化危机");
        games.add("CS");
        student.setGames(games);
        student.setWife(null);

        Properties info = new Properties();
        info.setProperty("性别", "二椅子");
        info.setProperty("籍贯", "USA");
        student.setInfo(info);

        //Spring能够按照类型找到容器里Address的bean，所以这里能注入成功，虽然bean的名字改成了'address222'
        student.setAddress(address);

        return student;
    }
}