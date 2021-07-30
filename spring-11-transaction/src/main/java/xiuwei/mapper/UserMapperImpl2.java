package xiuwei.mapper;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import xiuwei.pojo.User;

import java.util.List;

//使用SqlSessionDaoSupport，进一步简化。(了解即可)
//需要继承'SqlSessionDaoSupport'类
public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper {
    public List<User> selectUser() {
        //可以直接使用getSqlSession方法，获取sql session。
        return getSqlSession().getMapper(UserMapper.class).selectUser();
    }

    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }

    //这个方法是事务管理的。
    //如果deleteUser失败，addUser应该也失败，才符合事务定义。
    public void testTransactionMethod(){
        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
        int id = 110;
        int i = mapper.addUser(new User(id, "name", "12345"));
        int j = mapper.deleteUser(id);
        System.out.println(i + " " + j);
    }
}
