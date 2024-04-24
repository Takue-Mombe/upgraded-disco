package com.loginregistration.loginregistration1.Service;

import com.loginregistration.loginregistration1.DataModels.Roles;
import com.loginregistration.loginregistration1.DataModels.UserDto;
import com.loginregistration.loginregistration1.DataModels.UserModel;
import com.loginregistration.loginregistration1.Repositories.RoleRepository;
import com.loginregistration.loginregistration1.Repositories.StudentRepository;
import com.loginregistration.loginregistration1.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           StudentRepository studentRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        // Check if the user already exists in the system
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new RuntimeException("User with this email already exists");
        }

        // Check if the student exists in the system
        if (!studentRepository.existsByHitmail(userDto.getEmail())) {
            throw new RuntimeException("Student with this email does not exist");
        }

        UserModel user = new UserModel();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        // Encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Roles role = roleRepository.findByName("ROLE_STUDENT");
        if (role == null) {
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public UserModel findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<UserModel> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(UserModel user){
        UserDto userDto = new UserDto();
        String[] str = user.getName().split(" ");
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private Roles checkRoleExist(){
        Roles role = new Roles();
        role.setName("ROLE_STUDENT");
        return roleRepository.save(role);
    }
}