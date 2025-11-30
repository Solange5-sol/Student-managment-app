package com.example.students.controller;

import com.example.students.model.Students;
import com.example.students.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public ResponseEntity<?> getAllStudents() {
       List<Students> student= studentService.getAllStudents();
       if(student.isEmpty()){
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        Students student =studentService.getStudentById(id);
        if(student == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
    }
    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody Students student) {
        Students students=studentService.createStudent(student);
        return new ResponseEntity<>(students, HttpStatus.CREATED);
    }
    @PutMapping ("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id , @RequestBody Students student) {
        Students Student = studentService.updateStudent(id,student);
        if(Student == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(Student, HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/search")
    public ResponseEntity<?> searchStudent(@RequestParam String name) {
        List<Students> students = studentService.searchStudentByName(name);
        if(students.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(students, HttpStatus.OK);
        }
    }
}
