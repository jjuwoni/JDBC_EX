package com.wanted.crud.course.controller;

import com.wanted.crud.course.model.dto.CourseDTO;
import com.wanted.crud.course.model.service.CourseService;

import java.util.List;

public class CourseController {


    /* comment.
    *   Controller 계층의 책임
    *   - Controller 는 View 와 Service 사이를 연결하는 커멘드 센터
    *   - View 가 사용자에게 입력을 받고, 그 입력을 Controller 에게 전달하면
    *   - Controller 는 적절한 Service 계층의 메서드를 호출한다.
    *   - Controller 가 해야 할 일
    *   - 1. View 에서 받은 요청을 처리하는 메서드
    *   - 2. Service 메서드 호출 코드
    *   - 3. 필요하면 DTO/객체를 조립하는 코드
    *   - Controller 가 하면 안 되는 일
    *   - 1. Scanner 입력처리
    *   - 2. 출력처리
    *   - 3. SQL 작성
    *   - 4. commit / rollback 작업
    *
    * */

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    public boolean updateCourse(long id, String title, String description) {
        return true;
    }

    public List<CourseDTO> findAllCourse() {

        return service.findAllCourses();
    }
}
