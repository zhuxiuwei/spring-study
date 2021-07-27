package xiuwei.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import xiuwei.pojo.User;

import java.util.List;

public class UserMapperImpl implements UserMapper {
    //我们的所有操作，在原来都使用sqlSession来执行，现在都使用sqlSessionTemplate
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> selectUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.selectUser();
    }
}
