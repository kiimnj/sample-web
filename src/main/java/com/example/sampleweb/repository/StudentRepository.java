package com.example.sampleweb.repository;

import com.example.sampleweb.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    Student findById(int studentId);
    Student removeById(int studentId);
    Student add(Student student);
    Student update(int studentId, Student student);
}
