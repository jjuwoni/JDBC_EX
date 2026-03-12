package com.wanted.a_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application01 {
    public static void main(String[] args) {

        /* MySQL 접속을 위한  Connection 객체 생성 */

        // null 이라고 한 이유는 finally 블럭에서 해제를 하기 위함
        Connection con = null;

        // 사용할 드라이버 등록
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connection 은 인터페이스이기 때문에 직접 객체를 생성하지 못 한다
            // 따라서 Connection을 생성해는 DriverManager 를 통해 우리가 사용할 DB의 정보를 넘겨주며
            // 객체를 생성한다
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/employee",
                    "wanted",
                    "wanted");
            System.out.println("con = " + con);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // 그러나 이대로 깃허브에 올리게 되면 나의 비밀번호가 다 노출됨
    }
}
