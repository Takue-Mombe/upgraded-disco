package com.loginregistration.loginregistration1.Service;

import com.loginregistration.loginregistration1.DataModels.Courses;
import com.loginregistration.loginregistration1.DataModels.Programs;
import com.loginregistration.loginregistration1.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Courses saveCourse(Courses course) {
        return courseRepository.save(course);
    }

    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }
    public List<Courses> getCoursesByIds(List<Long> courseIds) {
        return courseRepository.findAllById(courseIds);
    }



    public Courses getCourseById(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new NoSuchElementException("Course not found with ID: " + courseId));
    }
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public List<Courses> getCoursesByProgram(Programs program) {
        return courseRepository.findByPrograms(program);
    }
}
