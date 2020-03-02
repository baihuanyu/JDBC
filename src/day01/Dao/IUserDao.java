package day01.Dao;

import day01.entity.User;

import java.util.List;

public interface IUserDao {

    void add(User user);

    void delete(int id);

    void update(User user);

    void findOne(int id);

    List<User> findAll();

}
