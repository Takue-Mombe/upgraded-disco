package com.loginregistration.loginregistration1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LecturerController {

    @GetMapping("/lecturer/dashboard")
    public String lecturerDashboard(Model model) {
        // Add any model attributes needed for the dashboard
        return "lecturer_dashboard";
    }
}
