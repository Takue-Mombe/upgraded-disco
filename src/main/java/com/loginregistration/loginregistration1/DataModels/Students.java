package com.loginregistration.loginregistration1.DataModels;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "students")
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class Students {
    @Id
    private String hitmail;
    @Column
    private String name;
}
