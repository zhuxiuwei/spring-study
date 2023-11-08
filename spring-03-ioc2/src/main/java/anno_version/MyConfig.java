package anno_version;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pojo.User;

@Configuration
public class MyConfig {
    @Bean
    public User u1(){
        return new User("aaa");
    }

    @Bean
    public User u2(){
        return new User();
    }
    /**
     * 相比xml版花里胡哨的constructor-arg构造方式，注解版应该是不支持那么多种类。
     */
}
