package com.example.sampleweb.service;

import com.example.sampleweb.repository.StudentRepository;
import com.example.sampleweb.repository.StudentRepositoryImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    StudentRepository studentRepository = new StudentRepositoryImpl();
    StudentService studentService = new StudentService(studentRepository);
//    @Test

}