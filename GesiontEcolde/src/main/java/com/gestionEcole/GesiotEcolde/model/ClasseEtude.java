package com.gestionEcole.GesiotEcolde.model;

import com.gestionEcole.GesiotEcolde.utils.AbstractClasse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class ClasseEtude extends AbstractClasse {

   /* @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id ;*/

    @Column(name = "nomClasse")
    private String nomClasse ;
    @Column(name = "anneeScolaire")
    private String annee ;
    @Column(name = "specialite")
    private String specialite ;
    @OneToMany(mappedBy = "classeEtude")
    private List<Student> studentId;

}
