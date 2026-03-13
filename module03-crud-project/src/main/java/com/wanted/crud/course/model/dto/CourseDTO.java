package com.wanted.crud.course.model.dto;

public class CourseDTO {
    private Long courseId;
    private Long authorId;
    private String title;
    private String description;
    private String status;

    public CourseDTO(Long courseId, Long authorId, String title, String description, String status) {
        this.courseId = courseId;
        this.authorId = authorId;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public CourseDTO() {

    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "courseId=" + courseId +
                ", authorId=" + authorId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
