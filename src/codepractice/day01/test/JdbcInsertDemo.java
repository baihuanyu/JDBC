package codepractice.day01.test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsertDemo {
    public static void main(String[] args) {
        Connection conn = null ;
        Statement st = null ;

        try {
        //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            //如果插入字符为中文 需要使用？useUnicode=true&characterEncoding=utf8&useSSL=false
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useUnicode=true&characterEncoding=utf8&useSSL=false", "root", "123456");
            // 编写sql语句
            String sql = "insert into user(uname,uage) values('钱多多',2)";
            //获取statement对象
            st = conn.createStatement();
            st.executeUpdate(sql);
            System.out.println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
