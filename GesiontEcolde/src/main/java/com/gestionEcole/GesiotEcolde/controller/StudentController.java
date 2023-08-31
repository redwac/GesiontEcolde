package com.gestionEcole.GesiotEcolde.controller;

import com.gestionEcole.GesiotEcolde.service.StudentService;
import com.gestionEcole.GesiotEcolde.model.Student;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/api/v1")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/liststudent")
    public List<Student> getStudent(){
       return studentService.getStudent();
    }

    @PostMapping("/create")
    public void postStudent(@RequestBody Student student){
        String email = student.getEmail();
        studentService.postStudent(student, email);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping("/update/{id}")
    public void updateStudent(@RequestBody Student student,@PathVariable Long id){
        studentService.updateStudent(student,id);
    }


}

