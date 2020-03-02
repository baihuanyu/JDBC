package day01.main;

import day01.Dao.impl.UserDaoImpl;
import day01.entity.User;

import java.util.List;

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
