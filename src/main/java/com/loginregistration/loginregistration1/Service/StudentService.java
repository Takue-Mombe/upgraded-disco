package com.loginregistration.loginregistration1.Service;


import com.loginregistration.loginregistration1.DataModels.Courses;
import com.loginregistration.loginregistration1.DataModels.Student;
import com.loginregistration.loginregistration1.DataModels.Students;
import com.loginregistration.loginregistration1.Repositories.CourseRepository;
import com.loginregistration.loginregistration1.Repositories.StudentRepository;
import com.loginregistration.loginregistration1.Repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentsRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;


    private void save(Student student){
        studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentsByCourse(List<Courses> courses) {
        return studentRepository.findByCoursesIn(courses);
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public void deleteCourse(Long id) {
        studentRepository.deleteById(id);
    }


    public List<Student> getStudentsByCourseId(Long courseId) {
        Optional<Courses> courseOptional = courseRepository.findById(courseId);

        if (courseOptional.isPresent()) {
            Courses course = courseOptional.get();
            return course.getStudent();
        } else {
            return Collections.emptyList();
        }
    }
}
