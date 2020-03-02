package homework.dao;

import day01.entity.User;
import homework.entity.Student;

import java.util.List;

public interface IStudentDao {
    /**增*/
    void add(Student s);
    /**删*/
    void delete(int id);
    /**改*/
    void update(Student s);
    /**查*/
    void findOne(int id);
    /**查全部*/
    List<Student> findAll();
}
