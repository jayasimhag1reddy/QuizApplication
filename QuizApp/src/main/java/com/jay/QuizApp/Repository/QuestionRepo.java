package com.jay.QuizApp.Repository;

import com.jay.QuizApp.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "Select * from Question q where q.category=:cat ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
    List<Question> findByNumAndCat(int numQ, String cat);
}
