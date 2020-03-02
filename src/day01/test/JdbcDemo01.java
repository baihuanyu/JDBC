package day01.test;

import java.sql.*;

public class JdbcDemo01 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null ;
        ResultSet rs = null;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //进行连接
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db", "root", "123456");
            //编写sql语句
            String sql = "select * from user";
            //获取执行对象
            st = conn.createStatement();
            //执行sql语句
            //查询功能语句 , 获取set结果集
            rs= st.executeQuery(sql);
            //遍历set集
            while (rs.next()){
                int uid = rs.getInt("uid");
                String uname = rs.getString("uname");
                int uage = rs.getInt("uage");
                System.out.println(uid+"  "+uname+"  "+uage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关流
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
