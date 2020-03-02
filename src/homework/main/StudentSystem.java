package homework.main;

import homework.dao.impl.StudentDaoImpl;
import homework.entity.Student;

import java.util.List;

public class StudentSystem {
    public static void main(String[] args) {
        Student student = new Student("李四", "123456", 19, false, "你好");
        Student student1 = new Student(1, "网吧", "2222", 22, false, "xx");
        StudentDaoImpl dao = new StudentDaoImpl();
        //添加
       // dao.add(student);
        //删除
        //dao.delete(3);
        //修改
        dao.update(student1);
        //dao.findOne(1);
        //List<Student> all = dao.findAll();
        //System.out.println(all);



    }
}
