package com.gestionEcole.GesiotEcolde.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class ClasseEtude {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id ;
    private String nomClasse ;
    private String annee ;
    private String specialite ;

}
