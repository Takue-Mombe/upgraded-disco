package com.loginregistration.loginregistration1.DataModels;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "semester")
@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long semester_id;
    @Column(unique = true)
    private String semester_name;

    @OneToMany(mappedBy = "semester")
    private List<Student> students = new ArrayList<>();


}
