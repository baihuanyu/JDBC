package homework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * jdbc 工具
 *
 * */
public class JDBCUtils {
    private  static String DRIVER ;
    private  static String URL;
    private  static String USERNAME ;
    private  static String PASSWORD;
    static {
        try {
            // 获取对象
            Properties ps = new Properties();
            // 获取流
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("dbStu.properties");
            //加载流
            ps.load(inputStream);
            //赋值
            DRIVER = ps.getProperty("mysql.driver");
            URL = ps.getProperty("mysql.url");
            USERNAME = ps.getProperty("mysql.user");
            PASSWORD = ps.getProperty("mysql.password");
            //加载驱动
            Class.forName(DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取连接的方法
     * */
    public static Connection getConn(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn ;
    }
    /**释放资源*/
    public  static void close(Connection conn , Statement st , ResultSet rs){
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
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
