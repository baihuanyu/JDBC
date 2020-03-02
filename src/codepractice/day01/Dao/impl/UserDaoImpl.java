package codepractice.day01.Dao.impl;


import codepractice.day01.Dao.IUserDao;
import codepractice.day01.entity.User;
import codepractice.day01.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    @Override
    public void add(User user) {
        Connection conn =null ;
        PreparedStatement ps = null;
        Statement st = null;
        try {
            conn = JDBCUtils.getConn();
            String sql = "Insert into user(uname,uage,ugander) VALUES('"+user.getUname()+"',"+user.getUage()+","+user.isUgander()+")";
            st = conn.createStatement();
            int i = st.executeUpdate(sql);
            if (i>0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        Connection conn =null ;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtils.getConn();
            //编写sql语句
            String sql = "delete from user where id ="+id;
            //执行sql语句
            ps = conn.prepareStatement(sql);
            int i = ps.executeUpdate();
            if (i>0){
                System.out.println("删除成功!");
            }
            System.out.println("删除失败，或是id不存在");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,ps,null);
        }

    }

    @Override
    public void update(User u) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConn();
            //编写sql语句
            String sql = "update user set uname = '"+u.getUname()+"',uage='"+u.getUage()+"' " +
                    ",ugander= '"+u.isUgander()+"'where uid ="+u.getUid();
            //执行sql语句
            ps = conn.prepareStatement(sql);
            int i = ps.executeUpdate();
            if (i > 0 ){
                System.out.println(" 添加成功");
            }
            System.out.println(" 添加失败,或是id不对");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,ps,null);
        }


    }

    @Override
    public void findOne(int id) {
        Connection conn =null ;
        PreparedStatement ps = null;
        ResultSet rs =null;
        try {
            conn = JDBCUtils.getConn();
            //编写sql语句
            String sql = "select * from user where uid ="+id;
            //执行sql语句
            ps = conn.prepareStatement(sql);
            //返回查询set集
            rs = ps.executeQuery();
            //遍历集合
            while (rs.next()){
                int uid = rs.getInt("uid");
                String uName = rs.getString("uName");
                int uAge = rs.getInt("uAge");
                boolean uGander = rs.getBoolean("uGander");
                User user = new User(uid, uName, uAge, uGander);
                System.out.println(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,ps,rs);
        }


    }

    @Override
    public List<User> findAll() {
        Connection conn =null ;
        PreparedStatement ps = null;
        ResultSet rs =null;
        try {
            conn = JDBCUtils.getConn();
            //编写sql语句
            String sql = "select * from user";
            //执行sql语句
            ps = conn.prepareStatement(sql);
            //创建list集合
            ArrayList<User> list = new ArrayList<>();
            //返回查询set集
            rs = ps.executeQuery();
            //遍历集合
            while (rs.next()){
                int uid = rs.getInt("uid");
                String uName = rs.getString("uName");
                int uAge = rs.getInt("uAge");
                boolean uGander = rs.getBoolean("uGander");
                User user = new User(uid, uName, uAge, uGander);
                list.add(user);
            }

            return list ;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,ps,rs);
        }
        return null ;

    }
}
