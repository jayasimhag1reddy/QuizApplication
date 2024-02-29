package com.jay.QuizApp.Service;

import com.jay.QuizApp.Model.Question;
import com.jay.QuizApp.Model.Quiz;
import com.jay.QuizApp.Repository.QuestionRepo;
import com.jay.QuizApp.Repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuestionRepo questionRepo;
    public ResponseEntity<String> create(int numQ, String title, String cat) {
        List<Question> quizQuestions=questionRepo.findByNumAndCat(numQ,cat);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(quizQuestions);
        quizRepo.save(quiz);
        return new ResponseEntity<>("sucess", HttpStatus.CREATED);
    }

    public ResponseEntity<Optional<Quiz>> getQuiz(Integer id) {
        return new ResponseEntity<>(quizRepo.findById(id),HttpStatus.OK);
    }


    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        return new ResponseEntity<>(quizRepo.findAll(),HttpStatus.OK);
    }
}
