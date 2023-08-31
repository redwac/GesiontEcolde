package com.gestionEcole.GesiotEcolde.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name = "Squence_Student",
            sequenceName = "Sequence_Student",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Squence_Student"

    )
    private Long id;
    private String nom;
    private String email;
    private LocalDate dob ;
    @Transient
    private int age ;

    public Integer getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }
}
