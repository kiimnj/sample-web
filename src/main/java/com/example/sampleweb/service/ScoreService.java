package com.example.sampleweb.service;

import com.example.sampleweb.domain.Score;
import com.example.sampleweb.repository.ScoreRepository;
import com.example.sampleweb.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    private final StudentRepository studentRepository;
    private final ScoreRepository scoreRepository;

    public ScoreService(StudentRepository studentRepository, ScoreRepository scoreRepository) {
        this.studentRepository = studentRepository;
        this.scoreRepository = scoreRepository;
    }

    public Score getStudentScore(int id){
        return scoreRepository.findById(id);
    }

    public int addStudentScore(Score score){
        return scoreRepository.addScore(score);
    }
}
