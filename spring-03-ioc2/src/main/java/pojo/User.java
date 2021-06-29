package pojo;

public class User {

    public User() {
        System.out.println("无参构造函数！");
    }

    public User(String name){
        this.name = name;
        System.out.println("有参构造函数！");
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("name=" + name);
    }

}
