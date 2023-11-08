package anno_version1;

import dao.UserDaoMysqlImpl;
import dao.UserDaoOracleImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.UserService;
import service.UserServiceImpl;

/**
 * 配置类里使用@Bean注解，明确地往Spring容器里去注册bean。
 */
@Configuration
public class AppConfig1 {
    @Bean
    public UserDaoMysqlImpl userDaoMysqlImpl() {
        return new UserDaoMysqlImpl();
    }

    @Bean
    public UserDaoOracleImpl userDaoOracleImpl() {
        return new UserDaoOracleImpl();
    }

    @Bean
    public UserService userServiceImpl() {  //返回UserServiceImpl也行
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDaoMysqlImpl());
        return userService;
    }
}
