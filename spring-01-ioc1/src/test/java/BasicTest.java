import dao.UserDaoMysqlImpl;
import service.UserService;
import service.UserServiceImpl;

/**
 * 基础的使用set方式的客户端。
 * 还需要new对象。
 */
public class BasicTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ((UserServiceImpl) userService).setUserDao(new UserDaoMysqlImpl());

        userService.getUser();
    }
}
