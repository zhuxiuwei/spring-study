package anno_version2.dao;

import dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoMysqlImpl implements UserDao {
    public void getUser() {
        System.out.println("MySQL 获取用户实现！");
    }
}
