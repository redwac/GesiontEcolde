package com.gestionEcole.GesiotEcolde.service;

import com.gestionEcole.GesiotEcolde.model.Student;
import com.gestionEcole.GesiotEcolde.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository ;

   //@Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent(){

       return studentRepository.findAll();
    }

    public void postStudent(Student student, String email){

           //Student student1 = studentRepository.findStudentByEmail(email).get();
           if(!studentRepository.findStudentByEmail(email).isEmpty()){
               throw new EntityExistsException(" Email taken !!!");
           }else studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
       if(!studentRepository.findById(id).isPresent()){
           throw new NoSuchElementException(" Student to delete not found !!!");
       }else studentRepository.deleteById(id);
    }
    @Transactional
    public void updateStudent(Student student, Long id){

        Optional<Student> student2 = studentRepository.findById(id);
        if (!student2.isPresent()){
            throw new NoSuchElementException(" Student to update Not found !!!");
        }else {

            student2.get().setNom(student.getNom());
            student2.get().setEmail(student.getEmail());
            student2.get().setDob(student.getDob());
            }

    }
}
