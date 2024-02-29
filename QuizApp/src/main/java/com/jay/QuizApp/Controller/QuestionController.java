package com.jay.QuizApp.Controller;

import com.jay.QuizApp.Model.Question;
import com.jay.QuizApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @GetMapping("getQuestions")
    public ResponseEntity<List<Question>> getQuestions(){
        return service.getQuestions();
    }
    @GetMapping("getQuestionByCategory/{cat}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String cat){
        return service.getQuestionByCategory(cat);
    }
    @PostMapping("addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return service.addQuestion(question);
    }
    @PutMapping("editQuestion/{id}")
    public ResponseEntity<String> editQuestion(@PathVariable Integer id,@RequestBody Question question){
        return service.editQuestion(id,question);
    }
    @DeleteMapping("deleteQuestion/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id){
        return service.deleteQuestion(id);
    }
}
