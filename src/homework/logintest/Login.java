package homework.logintest;

import homework.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 模拟登陆操作
 *
 *
 * */
public class Login {
    public static void main(String[] args) {
        String username = "李四";
        String pwd = "123456";
        try {
            // 获取连接对象
            Connection conn = JDBCUtils.getConn();
            //执行的sql语句
            String sql = " select * from student where username ='"+username+"'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            // 因为只查询一条数据，所以可以光标下移就可以了
            rs.next();
            if (pwd.equals(rs.getString("password"))){
                System.out.println("登陆成功");

            }else {
                System.out.println("账号或者密码错误！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
