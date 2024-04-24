package com.loginregistration.loginregistration1.DataModels;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "course")
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class Courses {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long course_id;
    @Column(unique = true)
    private String course_code;
    @Column
    private String course_name;
    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;

    @ManyToMany(mappedBy = "courses")
    private List<Programs> programs = new ArrayList<>();
    @ManyToMany(mappedBy = "courses")
    private List<Student> student = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "course_lecturers",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "lecturer_id"))
    private List<Lecturers> lecturers = new ArrayList<>();

}
