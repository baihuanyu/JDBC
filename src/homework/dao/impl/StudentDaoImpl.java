package homework.dao.impl;

import homework.dao.IStudentDao;
import homework.entity.Student;
import homework.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**学生实现类*/
public class StudentDaoImpl implements IStudentDao {
    @Override
    public void add(Student s) {
        PreparedStatement ps = null;
        Connection conn = null ;
        try {
            //创建连接
            conn = JDBCUtils.getConn();
            // 编写sql语句
            String sql = "insert into student(username,password,age,sex,info) values(?,?,?,?,?)";
            //预加载sql
            ps = conn.prepareStatement(sql);
            ps.setString(1,s.getUsername());
            ps.setString(2,s.getPassword());
            ps.setInt(3,s.getAge());
            ps.setBoolean(4,s.isSex());
            ps.setString(5,s.getInfo());
            int i = ps.executeUpdate();
            if (i >0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,ps,null);
        }

    }

    @Override
    public void delete(int id) {
        Connection conn = null ;
        PreparedStatement ps = null ;
        try {
            conn = JDBCUtils.getConn();
            String sql = "delete from student where id ="+id;
            ps = conn.prepareStatement(sql);
            int i = ps.executeUpdate();
            if (i>0){
                System.out.println("删除成功！");
            }else{
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,ps,null);
        }

    }

    @Override
    public void update(Student s) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConn();
            String sql = "update student set username=?,password=?,age=?,sex=?,info=? where id="+s.getId();
            ps = conn.prepareStatement(sql);
            ps.setString(1,s.getUsername());
            ps.setString(2,s.getPassword());
            ps.setInt(3,s.getAge());
            ps.setBoolean(4,s.isSex());
            ps.setString(5,s.getInfo());
            int i = ps.executeUpdate();
            if (i>0){
                System.out.println("修改成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,ps,null);
        }

    }

    @Override
    public void findOne(int id) {
        PreparedStatement ps = null;
        ResultSet rs =null;
        Connection conn = JDBCUtils.getConn();
        String sql = "select * from student where id="+id;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                int id1 = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int age = rs.getInt("age");
                boolean sex = rs.getBoolean("sex");
                String info = rs.getString("info");
                Student student = new Student(id1, username, password, age, sex, info);
                System.out.println(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,ps,rs);
        }

    }

    @Override
    public List<Student> findAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        try {
            conn = JDBCUtils.getConn();
            String sql = "select * from student ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<Student> list = new ArrayList<>();
            while (rs.next()){
                int id1 = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int age = rs.getInt("age");
                boolean sex = rs.getBoolean("sex");
                String info = rs.getString("info");
                Student student = new Student(id1, username, password, age, sex, info);
                list.add(student);
            }
            return list ;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,ps,rs);
        }
        return null;
    }
}
