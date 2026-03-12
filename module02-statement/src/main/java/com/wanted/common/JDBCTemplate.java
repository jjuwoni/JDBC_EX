package com.wanted.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {

    /* comment.
    *   우리는 DB에 접속할 때마다 Connection 객체를 사용해야 한다.
    *
    * */

    public static Connection getConnection() {

        Connection con = null;

        Properties prop = new Properties();

        try {

            prop.load(new FileReader("src/main/java/com/wanted/config/jdbc-config.properties"));

            System.out.println("prop = " + prop);

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            // 사용할 드라이버 등록
            Class.forName(driver);

            // Connection 은 인터페이스이기 때문에 직접 객체를 생성하지 못한다.
            // 따라서 Connection 을 생성해주는 DriverManager 를 통해 우리가 사용할 DB의 정보를 넘겨주며 객체를 생성한다.
            con = DriverManager.getConnection(url, user, password);

            System.out.println("con = " + con);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    // 사용한 Connection을 닫아주는 메서드
    public static void close(Connection con) {
        try {
            // con 이 null 이 아니거나 닫혀있지 않으면 닫아준다
            if(con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement stmt) {
        try {
            // con 이 null 이 아니거나 닫혀있지 않으면 닫아준다
            if(stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rset) {
        try {
            // con 이 null 이 아니거나 닫혀있지 않으면 닫아준다
            if(rset != null && !rset.isClosed()) {
                rset.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


