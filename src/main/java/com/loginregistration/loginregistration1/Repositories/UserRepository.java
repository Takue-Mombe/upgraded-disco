package com.loginregistration.loginregistration1.Repositories;

import com.loginregistration.loginregistration1.DataModels.Roles;
import com.loginregistration.loginregistration1.DataModels.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, String> {

    UserModel findByEmail(String email);

}
