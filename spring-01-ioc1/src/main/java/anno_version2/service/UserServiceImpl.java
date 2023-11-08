package anno_version2.service;

import anno_version2.dao.UserDaoMysqlImpl;
import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;
@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired  //！！！精髓在这句话！！！！
    public void setUserDao(UserDaoMysqlImpl userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        this.userDao.getUser();
    }
}
