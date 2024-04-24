package com.loginregistration.loginregistration1.Controller;

import com.loginregistration.loginregistration1.DataModels.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @GetMapping("/student/dashboard")
    public String studentDashboard(Model model) {
        UserModel user = getCurrentUser();
        model.addAttribute("user", user);
        return "student_dashboard";
    }

    private UserModel getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();


        UserModel user = new UserModel();
        user.setName(name);
        user.setEmail(name);

        return user;
    }
}

