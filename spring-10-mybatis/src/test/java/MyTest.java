import com.xiuwei.mapper.UserMapper;
import com.xiuwei.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {
    @Test
    public void test() throws IOException {
        //以下四行可封装为工具类
        String resources = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resources);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = sessionFactory.openSession(true);  //true: 自动提交事务

        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();

        for(User user: users){
            System.out.println(user);
            //正常会打印mysql库里全部用户
//            User(id=1, name=朱, pwd=password)
//            User(id=2, name=曹, pwd=password)
        }
    }
}
