package com.student.service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService{

    private StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public boolean saveStudent(Student s) {
        Student savedStudent = repo.save(s);
        return savedStudent.getStuId() != null;
    }


    public List<Student> getAllStudents() {
        return repo.findAll();
    }


    public void delete(Integer stuId) {
        repo.deleteById(stuId);
    }
}
