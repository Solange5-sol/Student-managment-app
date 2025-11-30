package com.example.students.service;

import com.example.students.model.Students;
import com.example.students.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }
    public Students getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    public Students createStudent(Students student) {
        return studentRepository.save(student);
    }
    public Students updateStudent(Long id, Students updateStudent) {
        Students existingStudent = studentRepository.getReferenceById(id);
        if (existingStudent == null)
            return null;
        existingStudent.setAge(updateStudent.getAge());
        existingStudent.setEmail(updateStudent.getEmail());
        existingStudent.setName(updateStudent.getName());
        return studentRepository.save(existingStudent);
    }
    public void deleteStudentById(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        }
    }
    public List<Students> searchStudentByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }
}
