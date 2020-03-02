package homework.transferaccount;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 转账测试， 事务使用
 *             原子性，一致性，隔离线，持久性
 * */
public class TfAccountTest {
    public static void main(String[] args) {
        String sql = "";
        //加载驱动
        Properties p = new Properties();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("dbStu.properties"));
            Class.forName(p.getProperty("mysql.driver"));
            // 创建链接
            conn = DriverManager.getConnection(p.getProperty("mysql.url"), p.getProperty("mysql.username"), p.getProperty("mysql.password"));
            // 设置取消自动提交
            conn.setAutoCommit(false);
            //欲执行sql
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            sql = " 新sql 加钱";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            //最后提交事务
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //发生异常需要会滚
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            //关流
        }
    }
}
