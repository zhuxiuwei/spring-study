package anno_version;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import pojo.Cat;
import pojo.Dog;
import pojo.Person;

@Configuration
public class MyConfig {

    /**
     * Bean注解修饰的方法，参数也能自动注入容器里已有的组件，类似autowire效果。
     * https://blog.csdn.net/u014486725/article/details/122711602
     * https://blog.csdn.net/lazy_zzzzzz/article/details/94464337
     * Primary注解：该注解指定 当存在多个同类型的bean时，具有当前注解的bean会被作为首选
     * Qualifier注解：该注解指定 当存在多个同类型的bean时，通过其配置的value值，选择对应ID的Bean
     */
    @Bean
    public Person person(@Qualifier("dog1") Dog dog,
                         Cat cat){
        Person person = new Person();
        //以下的cat, dog都是autowire自动注入的
        person.setCat(cat);
        person.setDog(dog);
        person.setName("注解版name");
        return person;
    }

    @Bean
    public Dog dog1(){
        return new Dog();
    }

    @Bean
    public Dog dog2(){
        return new Dog();
    }

    @Bean
    @Primary
    public Cat cat1(){
        return new Cat();
    }

    @Bean
//    @Primary  //不能加两个@Primary，编译OK，运行时会报错：org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'pojo.Cat' available: more than one 'primary' bean found among candidates: [cat1, cat2]
    public Cat cat2(){
        return new Cat();
    }

}
