package com.gestionEcole.GesiotEcolde.repository;

import com.gestionEcole.GesiotEcolde.model.ClasseEtude;
import com.gestionEcole.GesiotEcolde.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClasseEtudeRepository extends JpaRepository<ClasseEtude, Long> {

    public Optional<ClasseEtude> findClassesEtudeByNomClasse(String email);
}
