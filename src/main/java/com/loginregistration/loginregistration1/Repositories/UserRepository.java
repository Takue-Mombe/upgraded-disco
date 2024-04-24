package com.loginregistration.loginregistration1.Repositories;

import com.loginregistration.loginregistration1.DataModels.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByEmail(String email);

    boolean existsByEmail(String email);
}
