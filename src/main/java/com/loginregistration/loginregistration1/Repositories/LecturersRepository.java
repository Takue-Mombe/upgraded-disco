package com.loginregistration.loginregistration1.Repositories;

import com.loginregistration.loginregistration1.DataModels.Lecturers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturersRepository extends JpaRepository<Lecturers, Long> {

}