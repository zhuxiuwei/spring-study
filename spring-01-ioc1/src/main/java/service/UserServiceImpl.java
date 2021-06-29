package service;

import dao.UserDao;
import dao.UserDaoMysqlImpl;

public class UserServiceImpl implements UserService{

//    private UserDao userDao = new UserDaoMysqlImpl();     //控制权在程序员这边，不行！
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {   //利用set进行动态实现值的注入！
        this.userDao = userDao;
    }

    public void getUser() {
        this.userDao.getUser();
    }
}
