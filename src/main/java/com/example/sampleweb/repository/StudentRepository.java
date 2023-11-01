package com.example.sampleweb.repository;

import com.example.sampleweb.domain.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentRepository {
    List<Student> findAll();
    Student findById(int id);
    void updateStudent(Student student);
    int addStudent(Student student);
}
