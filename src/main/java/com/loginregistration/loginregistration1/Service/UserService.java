package com.loginregistration.loginregistration1.Service;

import com.loginregistration.loginregistration1.DataModels.UserDto;
import com.loginregistration.loginregistration1.DataModels.UserModel;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    UserModel findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
