package anno_version;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pojo.Address;
import pojo.Student;
import java.util.*;

/**
 * 测试注解版。美团MC自动生成。231107
 */
@Configuration
public class AppConfig {

    @Bean
    public Address address222() {
        Address address = new Address();
        address.setAddress("北京市海淀区");
        return address;
    }

    @Bean
    public Student student(Address address) {
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