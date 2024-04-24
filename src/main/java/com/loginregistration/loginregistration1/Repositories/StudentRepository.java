package com.loginregistration.loginregistration1.Repositories;

import com.loginregistration.loginregistration1.DataModels.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Students,String> {
    boolean existsByHitmail(String hitmail);
}
