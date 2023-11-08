package anno_version2;

import anno_version2.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import service.UserService;

/**
 * ComponentScan + Autowire版本！
 */
@Configuration
@ComponentScan("anno_version2")
public class AppConfig2 {
    /**
     * 不像AppConfig1里需要用@Bean来明确注册组件，
     * 这个版本，这里什么都不用写，因为配置类里定义了@ComponentScan，容器会自动扫描可以注册的组件
     */
}
