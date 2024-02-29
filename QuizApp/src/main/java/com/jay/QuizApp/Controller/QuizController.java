package com.jay.QuizApp.Controller;

import com.jay.QuizApp.Model.Question;
import com.jay.QuizApp.Model.Quiz;
import com.jay.QuizApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> create(@RequestParam int numQ,@RequestParam String title,@RequestParam String cat){
//        return new ResponseEntity<>("Sucess", HttpStatus.OK);
        return quizService.create(numQ,title,cat);
    }
    @GetMapping("getQuiz/{id}")
    public ResponseEntity<Optional<Quiz>> getQuiz(@PathVariable Integer id){
        return quizService.getQuiz(id);
    }
    @GetMapping("getAllQuizzes")
    public ResponseEntity<List<Quiz>> getAllQuizzes(){
        return quizService.getAllQuizzes();
    }
}
