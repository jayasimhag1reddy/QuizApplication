package com.jay.QuizApp.Controller;

import com.jay.QuizApp.Model.Answers;
import com.jay.QuizApp.Model.Question;
import com.jay.QuizApp.Model.QuestionWrapper;
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
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id){
        return quizService.getQuiz(id);
    }
    @GetMapping("getAllQuizzes")
    public ResponseEntity<List<List<QuestionWrapper>>> getAllQuizzes(){

        return quizService.getAllQuizzes();
    }
    @PostMapping("submit/{id}")
    public  ResponseEntity<Integer> submit(@PathVariable Integer id, @RequestBody List<Answers> answer){
        return quizService.submit(id,answer);
    }
}
