package com.wanted.a_statements;

import com.wanted.common.EmployeeDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.wanted.common.JDBCTemplate.close;
import static com.wanted.common.JDBCTemplate.getConnection;

public class Application03 {
    public static void main(String[] args) {

        /* comment.
         *   Jdbc 의 핵심적인 인터페이스 2가지,
         *   1. Statement
         *   - SQL문을 저장하고 실행할 수 있는 기능을 가진 인터페이스
         *   2. ResultSet
         *   - SQL문 결과 집합을 받아올 수 있는 인터페이스
         * */

        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        // 1명의 모든 정보를 담을 수 있는 EmployeeDTO 객체 생성
        EmployeeDTO emp = null;

        try {
            // statement 는 Connection 을 통해 객체 생성
            stmt = con.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.print("조회하실 사번을 입력해주쇼!! : ");
            String empid = sc.nextLine();

            rset = stmt.executeQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = '" + empid + "'");

            if (rset.next()) {
               emp = new EmployeeDTO();

                emp.setEmpId(rset.getString("EMP_ID"));
                emp.setEmpName(rset.getString("EMP_NAME"));
                emp.setEmpNo(rset.getString("EMP_NO"));
                emp.setEmail(rset.getString("EMAIL"));
                emp.setPhone(rset.getString("PHONE"));
                emp.setDeptCode(rset.getString("DEPT_CODE"));
                emp.setJobCode(rset.getString("JOB_CODE"));
                emp.setSalLevel(rset.getString("SAL_LEVEL"));
                emp.setSalary(rset.getInt("SALARY"));
                emp.setBonus(rset.getDouble("BONUS"));
                emp.setManagerId(rset.getString("MANAGER_ID"));
                emp.setHireDate(rset.getDate("HIRE_DATE"));
                emp.setEntDate(rset.getDate("ENT_DATE"));
                emp.setEntYn(rset.getString("ENT_YN"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(stmt);
            close(con);
            close(rset);
        }

        System.out.println("조회 한 사원의 정보 : " + emp);
    }
}
