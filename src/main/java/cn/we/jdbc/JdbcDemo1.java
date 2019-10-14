package cn.we.jdbc;

import java.sql.*;

/**
 * @author gradyzhou
 * @version 1.0, on 21:01 2019/9/19.
 */
public class JdbcDemo1 {

    public static void main(String[] args) throws SQLException {

        //1,
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

//        2,
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306","grady","pwd");

        //3,获取操作数据库的预处理对象
        PreparedStatement pstm = conn.prepareStatement("select * from accout");

        ResultSet rs = pstm.executeQuery();

        while (rs.next()){
            System.out.println(rs.getString("name"));
        }

        rs.close();
        pstm.close();
        conn.close();
    }
}
















