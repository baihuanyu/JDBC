package codepractice.day01.main;

import codepractice.day01.Dao.impl.UserDaoImpl;
import codepractice.day01.entity.User;

/**
 * 用于对用户表增删改查
 * */
public class UserSystem {
    public static void main(String[] args) {
        User user = new User( "李四", 23, true);
        UserDaoImpl dao = new UserDaoImpl();
        dao.add(user);
    }
}
