package com.loginregistration.loginregistration1.Controller;

import com.loginregistration.loginregistration1.DataModels.Semester;
import com.loginregistration.loginregistration1.Service.ProgramService;
import com.loginregistration.loginregistration1.Service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/semesters")
public class SemesterController {

    @Autowired
    private SemesterService semesterService;

    @Autowired
    private ProgramService programService;

    @GetMapping("/list")
    public String listSemesters(Model model) {
        List<Semester> semesters = semesterService.getAll();
        model.addAttribute("semesters", semesters);
        return "semesterlist";
    }

    @GetMapping("/add")
    public String showAddSemesterForm(Model model) {
        model.addAttribute("semester", new Semester());
        return "semesterlist";
    }

    @PostMapping("/add")
    public String addSemester(@ModelAttribute("semester") Semester semester, BindingResult result,
                              RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            // Handle validation errors
            return "semesterlist";
        }
        semesterService.save(semester);
        redirectAttributes.addFlashAttribute("successMessage", "Semester added successfully.");
        return "redirect:/semesters/list";
    }

    // Add mappings for edit, delete, and other operations
}

