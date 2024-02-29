package com.jay.QuizApp.Service;

import com.jay.QuizApp.Model.Question;
import com.jay.QuizApp.Repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepo repo;
    public ResponseEntity<List<Question>> getQuestions() {
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        repo.save(question);
        return new ResponseEntity<>("Sucess",HttpStatus.CREATED);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String cat) {
        return new ResponseEntity<>(repo.findByCategory(cat),HttpStatus.OK);
    }

    public ResponseEntity<String> deleteQuestion(Integer id) {
        repo.deleteById(id);
        return new ResponseEntity<>("Sucess",HttpStatus.OK);
    }

    public ResponseEntity<String> editQuestion(Integer id,Question question) {
        repo.deleteById(id);
        repo.save(question);
        return new ResponseEntity<>("Sucess",HttpStatus.CREATED);
    }
}
