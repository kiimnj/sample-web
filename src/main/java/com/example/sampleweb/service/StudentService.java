package com.example.sampleweb.service;

import com.example.sampleweb.domain.Score;
import com.example.sampleweb.domain.Student;
import com.example.sampleweb.repository.ScoreRepository;
import com.example.sampleweb.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final ScoreRepository scoreRepository;

    public StudentService(StudentRepository studentRepository, ScoreRepository scoreRepository) {
        this.studentRepository = studentRepository;
        this.scoreRepository = scoreRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentInfo(int id){
        return studentRepository.findById(id);
    }

    public void updateStudent(int id){
        Student findStudent = studentRepository.findById(id);
        Score findScore = scoreRepository.findById(id);
        float resScore = (findStudent.getPoint() + findScore.getSPoint())/2.0f;
        findStudent.setPoint(resScore);
        studentRepository.updateStudent(findStudent);
    }

    public int addNewStudent(Student student){
        int id = studentRepository.addStudent(student);
        System.out.println(id);
        return id;   // 확인!!
    }
}
