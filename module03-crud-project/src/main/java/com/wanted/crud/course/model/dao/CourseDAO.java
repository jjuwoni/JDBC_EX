package com.wanted.crud.course.model.dao;

import com.wanted.crud.course.model.dto.CourseDTO;
import com.wanted.crud.global.utils.QueryUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    /* comment.
     *   DAO 계층의 역할
     *   - Data Access Object 약자
     *   - 즉, DAO 클래스는 DB 로 접근하기 위한 마지막 관문
     *   DAO 가 해야 할 일
     *   - 1. SQL 구문을 실행한다.
     *   - 2. PreparedStatement 생서
     *   - 3. 전달 받은 파라미터를 바인딩한다. -> (? -> 값 대입)
     *   - 4. ResultSet 을 SQL 결과를 받는다.
     *   - 5. SQL 결과를 Java 객체로 변환한다.
     * */

    private final Connection connection;

    public CourseDAO(Connection connection) {
        this.connection = connection;
    }

    /* 전체 조회 쿼리문을 동작 시키는 메소드 */
    public List<CourseDTO> findAll() throws SQLException {

        // 동작시킬 쿼리문 준비
        String query = QueryUtil.getQuery("course.findAll");
        List<CourseDTO> courseList = new ArrayList<>();
        // 쿼리문 동작
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {

            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                CourseDTO course = new CourseDTO(
                        rset.getLong("course_id"),
                        rset.getLong("author_id"),
                        rset.getString("title"),
                        rset.getString("description"),
                        rset.getString("status")
                );
                courseList.add(course);
            }

        }

        return courseList;
    }
}

