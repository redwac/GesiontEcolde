package com.gestionEcole.GesiotEcolde.controller;

import com.gestionEcole.GesiotEcolde.model.ClasseEtude;
import com.gestionEcole.GesiotEcolde.service.ClasseEtudeService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/classes")
@NoArgsConstructor
public class ClasseEtudeController {

    ClasseEtudeService classeEtudeService ;

    @Autowired
    public ClasseEtudeController(ClasseEtudeService classeEtudeService){
        this.classeEtudeService =classeEtudeService ;
    }

    @GetMapping("/list")
    public List<ClasseEtude> getClasses(){
        return classeEtudeService.getClasses();
    }

    @PostMapping("/create")
    public void postClasse(@RequestBody ClasseEtude classeEtude){
        String nomClasse = classeEtude.getNomClasse();
        classeEtudeService.postClasse(classeEtude,nomClasse);
    }

    @PutMapping("/update/{id}")
    public void putClasse(@RequestBody ClasseEtude classeEtude, @PathVariable Long id){
        classeEtudeService.putClasse(classeEtude,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClasse(@PathVariable Long id){
        classeEtudeService.deleteClasse(id);
    }
}
