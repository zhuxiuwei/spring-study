package xiuwei.mapper;

import org.mybatis.spring.SqlSessionTemplate;
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
}
