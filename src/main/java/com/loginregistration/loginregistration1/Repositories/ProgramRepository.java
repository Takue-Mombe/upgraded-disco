package com.loginregistration.loginregistration1.Repositories;


import com.loginregistration.loginregistration1.DataModels.Programs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends JpaRepository<Programs,Long> {
}
