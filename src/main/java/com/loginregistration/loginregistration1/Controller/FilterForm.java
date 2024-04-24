package com.loginregistration.loginregistration1.Controller;

public class FilterForm {
    private Long courseId;

    public FilterForm() {
    }

    public FilterForm(Long courseId) {
        this.courseId = courseId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
