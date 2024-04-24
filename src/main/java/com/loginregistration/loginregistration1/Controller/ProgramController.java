package com.loginregistration.loginregistration1.Controller;

import com.loginregistration.loginregistration1.DataModels.Programs;
import com.loginregistration.loginregistration1.Service.CourseService;
import com.loginregistration.loginregistration1.Service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/programs")
public class ProgramController {

    @Autowired
    private ProgramService programService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/list")
    public String listPrograms(Model model) {
        List<Programs> programs = programService.getAllPrograms();
        model.addAttribute("courses", courseService.getAllCourses());
        model.addAttribute("programs", programs);
        return "ProgramList";
    }

    @GetMapping("/add")
    public String showAddProgramForm(Model model) {
        model.addAttribute("program", new Programs());
        return "ProgramList";
    }

    @PostMapping("/add")
    public String addProgram(@ModelAttribute("program") Programs program, BindingResult result,
                             RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            // Handle validation errors
            return "ProgramList";
        }
        programService.saveProgram(program);
        redirectAttributes.addFlashAttribute("successMessage", "Program added successfully.");
        return "redirect:/programs/list";
    }

    // Add mappings for edit, delete, and other operations
}

