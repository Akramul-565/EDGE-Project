package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public Student updateStudent(Long id, Student student) {
        Optional<Student> existing = repository.findById(id);
        if (existing.isPresent()) {
            Student s = existing.get();
            s.setName(student.getName());
            s.setEmail(student.getEmail());
            s.setCourse(student.getCourse());
            return repository.save(s);
        }
        return null;
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
