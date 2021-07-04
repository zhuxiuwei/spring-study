package pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

/**
 * 测试注解方式注入。 - @Autowired
 */
public class Person {
    @Autowired
    @Nullable
    private Dog dog;    //配置文件里dog定义多次，byType无法匹配，则byName自动匹配上了（bean id=属性名）
    @Autowired
    private Cat cat;

    @Autowired
    @Qualifier(value = "dog2")   //配置文件里dog定义多次，byType无法匹配，byName自动匹配也不行，则通过@Qualifier显示指定匹配的bean
    private Dog anotherDog;
    @Autowired
    @Qualifier(value = "cat2")
    private Cat anotherCat;

    private String name;

    public Dog getDog() {
        return dog;
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    //注解加在set方法处也可以！！！但是如果注解写在属性上，set方法实际可以去掉了。
    //@Autowired
//    public void setDog(Dog dog) {
//        this.dog = dog;
//    }

    public Cat getCat() {
        return cat;
    }

//    public void setCat(Cat cat) {
//        this.cat = cat;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "dog=" + dog +
                ", cat=" + cat +
                ", name='" + name + '\'' +
                '}';
    }
}
