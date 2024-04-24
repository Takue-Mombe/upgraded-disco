package com.loginregistration.loginregistration1.Repositories;

import com.loginregistration.loginregistration1.DataModels.Courses;
import com.loginregistration.loginregistration1.DataModels.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Student,Long> {
    List<Student> findByCoursesIn(List<Courses> courses);
}