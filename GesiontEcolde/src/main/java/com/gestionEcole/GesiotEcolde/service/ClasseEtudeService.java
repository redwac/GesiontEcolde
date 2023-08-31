package com.gestionEcole.GesiotEcolde.service;

import com.gestionEcole.GesiotEcolde.model.ClasseEtude;
import com.gestionEcole.GesiotEcolde.repository.ClasseEtudeRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClasseEtudeService {

    ClasseEtudeRepository classeEtudeRepository ;

    @Autowired
    public ClasseEtudeService(ClasseEtudeRepository classeEtudeRepository){
        this.classeEtudeRepository = classeEtudeRepository;
    }

    public List<ClasseEtude> getClasses(){
        return classeEtudeRepository.findAll();
    }

    public void postClasse(ClasseEtude classeEtude, String nomClasse){

        ClasseEtude classeEtude1 = classeEtudeRepository.findClassesEtudeByNomClasse(nomClasse).orElse(null);
        if(!classeEtudeRepository.findClassesEtudeByNomClasse(nomClasse).isEmpty()){
            throw new IllegalStateException("Element existe !!! ");

        }else classeEtudeRepository.save(classeEtude);
    }

    @Transactional
    public void putClasse(ClasseEtude classeEtude, Long id) {

        Optional<ClasseEtude> classeEtude2 = classeEtudeRepository.findById(id);
        if(classeEtude2.isPresent()){
            classeEtude2.get().setNomClasse(classeEtude.getNomClasse());
            classeEtude2.get().setAnnee(classeEtude.getAnnee());
            classeEtude2.get().setSpecialite(classeEtude.getSpecialite());
        }else throw new IllegalStateException(" Not found element to update !!! ");
        /*if (!classeEtudeRepository.findById(id).isPresent()){
            throw new IllegalStateException("Classe Etude to update Not found !! ");
        }else {
           // if (!classeEtude.getNomClasse().equals(null)){

            //}
            classeEtude1.setNomClasse(classeEtude.getNomClasse());
            classeEtude1.setAnnee(classeEtude.getAnnee());
            classeEtude1.setSpecialite(classeEtude.getSpecialite());*/
           /* if ( !classeEtude.getAnnee().equals(null)){

            }
            if (!classeEtude.getSpecialite().equals(null)){

            }

            System.out.println("Modification de la classe " + classeEtude1);
        }*/
    }

    public void deleteClasse(Long id) {
        try {
            ClasseEtude classeEtude = classeEtudeRepository.findById(id).orElse(null);
            if (!classeEtudeRepository.findById(id).isPresent()){
                throw new IllegalStateException("Classe Etude to delete not found !!! ");
            }
            else classeEtudeRepository.deleteById(id);
        }catch (Exception e){
            throw new  IllegalStateException("Element to delete not found !!! ");
        }

    }
}
