package com.loginregistration.loginregistration1.Controller;

import com.loginregistration.loginregistration1.DataModels.Courses;
import com.loginregistration.loginregistration1.DataModels.Semester;
import com.loginregistration.loginregistration1.DataModels.Student;
import com.loginregistration.loginregistration1.DataModels.Students;
import com.loginregistration.loginregistration1.Service.CourseService;
import com.loginregistration.loginregistration1.Service.ProgramService;
import com.loginregistration.loginregistration1.Service.SemesterService;
import com.loginregistration.loginregistration1.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private SemesterService semesterService;
    @Autowired
    private ProgramService programService;

    @GetMapping("/list")
    public String listCourses(Model model) {
        List<Courses> courses = courseService.getAllCourses();
        List<Semester> semesters = semesterService.getAll();
        model.addAttribute("courses", courses);
        model.addAttribute("semesters", semesters);
        return "courselis";
    }
    @GetMapping("/listing")
    public String listCourses(Model model, @RequestParam(required = false) Long courseId) {
        List<Courses> courses = courseService.getAllCourses();
        List<Student> students;

        if(courseId != null) {
            students = studentService.getStudentsByCourseId(courseId); // Assuming you have a method to fetch students by courseId
        } else {
            students = studentService.getAllStudents();
        }

        model.addAttribute("courses", courses);
        model.addAttribute("filteredStudents", students);
        model.addAttribute("filterForm", new FilterForm(courseId)); // Create an instance of FilterForm and set courseId
        return "course-list";
    }








    @GetMapping("/add")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new Courses());
        return "courselis";
    }

    @PostMapping("/add")
    public String addCourse(@ModelAttribute("course") Courses course, BindingResult result,
                            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            // Handle validation errors
            return "courselis";
        }
        courseService.saveCourse(course);
        redirectAttributes.addFlashAttribute("successMessage", "Course added successfully.");
        return "redirect:/courses/list";
    }
    @PostMapping("/delete")
    public String deleteCourse(@RequestParam("course_id") Long courseId) {
        System.out.println("Deleting course with ID: " + courseId);
        courseService.deleteCourse(courseId);


        return "redirect:/courses/list";
    }
}

