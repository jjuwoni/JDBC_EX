package com.wanted.a_statements;

import com.wanted.common.EmployeeDTO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import java.util.Scanner;

import static com.wanted.common.JDBCTemplate.close;
import static com.wanted.common.JDBCTemplate.getConnection;

public class Application04 {

    /* comment. 하부르타 시 해야할 일
    *   SELECT * FROM EMPLOYEE;
    *   EmployeeDTO 에 1명을 담았었다.
    *   그렇다면 모든 회원은 어떻게 담을까?
    * */

    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        // 1명의 모든 정보를 담을 수 있는 EmployeeDTO 객체 생성
        EmployeeDTO emp = null;

        Properties prop = new Properties();

        try {

            prop.loadFromXML(
                    new FileInputStream("src/main/java/com/wanted/b_preparedstatements/employee-query.xml")
            );

            String query = prop.getProperty("selectAll");

            // statement 는 Connection 을 통해 객체 생성
            pstmt = con.prepareStatement(query);

            rset = pstmt.executeQuery();

            while(rset.next()) {
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

                System.out.println("사원의 정보 : " + emp);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvalidPropertiesFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
            close(rset);
        }
    }



}
