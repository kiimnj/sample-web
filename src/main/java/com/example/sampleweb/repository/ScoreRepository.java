package com.example.sampleweb.repository;

import com.example.sampleweb.domain.Score;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScoreRepository {
    List<Score> findAll();
    Score findById(int id);
    int addScore(Score score);
    int updateScore(Score score);
    void deleteScore(int id);
}
