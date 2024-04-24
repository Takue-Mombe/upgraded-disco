package com.loginregistration.loginregistration1.DataModels;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "students")
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class Students {
    @Id
    private String hitmail;
    @Column
    private String name;
}
