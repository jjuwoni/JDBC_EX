package com.wanted.crud.course.model.service;

import com.wanted.crud.course.model.dao.CourseDAO;
import com.wanted.crud.course.model.dao.CourseSectionDAO;
import com.wanted.crud.course.model.dto.CourseDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CourseService {

    /* comment.
    *   Service 계층의 역할
    *   - Service 계층은 비즈니스 로직을 담당하는 계층이다.
    *   - 비즈니스 로직이란?
    *   - 단순히 SQL 을 실행하는 것이 아닌,
    *   - 우리 프로젝트(회사) 규칙 상 어떤 순서로 어떤 처리를 하는가를
    *   - 다루는 구문을 의미한다.
    *   Service 계층이 해야 할 일
    *   - 1. DAO 를 호출
    *   - 2. 데이터를 검증/가공
    *   - 3. 필요 시 여러 DAO 를 조합(EX- 강의를 삽입할 때 강의에 포함되는 챕터, 섹션 삽입)
    *   - 4. 트랜잭션 처리(commit rollback)
    *   - 5. 예외처리
    * */

    private final CourseDAO courseDAO;
    private final CourseSectionDAO courseSectionDAO;
    private final Connection connection;

    public CourseService(Connection connection) {
        this.courseDAO = new CourseDAO(connection);
        this.courseSectionDAO = new CourseSectionDAO(connection);
        this.connection = connection;
    }

    public List<CourseDTO> findAllCourses() {

        try {
            return courseDAO.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("강의 전체 조회 중 Error 발생!!🚨🚨🚨 " +e);
        }
    }
}
