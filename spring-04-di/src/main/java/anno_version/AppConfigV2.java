package anno_version;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ComponentScan + Autowire版
 */
@Configuration
@ComponentScan("anno_version.pojo")
public class AppConfigV2 {
}