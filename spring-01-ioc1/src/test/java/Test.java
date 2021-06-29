import dao.UserDaoMysqlImpl;
import service.UserService;
import service.UserServiceImpl;

public class Test {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ((UserServiceImpl) userService).setUserDao(new UserDaoMysqlImpl());

        userService.getUser();
    }
}
