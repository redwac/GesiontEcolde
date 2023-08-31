package com.gestionEcole.GesiotEcolde.model;

import com.gestionEcole.GesiotEcolde.utils.AbstractClasse;
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
public class Student extends AbstractClasse {

    /*@Id
    @SequenceGenerator(
            name = "Squence_Student",
            sequenceName = "Sequence_Student",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Squence_Student"

    )*/

    //private Long id;
    @Column(name = "studentName")
    private String nom;
    @Column(name = "emailStudent")
    private String email;
    @Column(name = "dateNaisance")
    private LocalDate dob ;
    @Transient
    private int age ;

    @ManyToOne()
    @JoinColumn(name = "idClasse")
    private ClasseEtude classeEtude;

    public Integer getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }
}
