package com.loginregistration.loginregistration1.Repositories;

import com.loginregistration.loginregistration1.DataModels.Courses;
import com.loginregistration.loginregistration1.DataModels.Programs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Long> {

    List<Courses> findByPrograms(Programs program);

}