package com.jay.QuizApp.Service;

import com.jay.QuizApp.Model.Answers;
import com.jay.QuizApp.Model.Question;
import com.jay.QuizApp.Model.QuestionWrapper;
import com.jay.QuizApp.Model.Quiz;
import com.jay.QuizApp.Repository.QuestionRepo;
import com.jay.QuizApp.Repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {
        Optional<Quiz> quiz=quizRepo.findById(id);
        List<Question> qstns=quiz.get().getQuestions();
        List<QuestionWrapper> quizQuestions=new ArrayList<>();
        for(Question qs:qstns){
            QuestionWrapper qw=new QuestionWrapper();
            qw.setId(qs.getId());
            qw.setQuestion(qs.getQuestion());
            qw.setOpt1(qs.getOpt1());
            qw.setOpt2(qs.getOpt2());
            qw.setOpt3(qs.getOpt3());
            qw.setOpt4(qs.getOpt4());
            quizQuestions.add(qw);
        }
        return new ResponseEntity<>(quizQuestions,HttpStatus.OK);
    }


    public ResponseEntity<List<List<QuestionWrapper>>> getAllQuizzes() {
        List<Quiz> quiz=quizRepo.findAll();
        List<List<QuestionWrapper>> quizQuestions=new ArrayList<>();
        for(Quiz q:quiz){
           List<Question> qst=q.getQuestions();
           List<QuestionWrapper> qw=new ArrayList<>();
           for(Question qstns:qst){
               QuestionWrapper qwrap=new QuestionWrapper();
               qwrap.setId(qstns.getId());
               qwrap.setQuestion(qstns.getQuestion());
               qwrap.setOpt1(qstns.getOpt1());
               qwrap.setOpt2(qstns.getOpt2());
               qwrap.setOpt3(qstns.getOpt3());
               qwrap.setOpt4(qstns.getOpt4());
               qw.add(qwrap);
           }
           quizQuestions.add(qw);
        }
        return new ResponseEntity<>(quizQuestions,HttpStatus.OK);
    }

    public ResponseEntity<Integer> submit(Integer id, List<Answers> answer) {
        Optional<Quiz> quiz=quizRepo.findById(id);
        int c=0;
        if(quiz.isPresent()){
            List<Question> qst=quiz.get().getQuestions();
//            System.out.println(qst);
            for(Answers as:answer){
                for(Question q:qst){
                    if(as.getId()==q.getId() && as.getAns().equals(q.getAns())){
                        c++;
                    }
                }
            }
        }
        return new ResponseEntity<>(c,HttpStatus.OK);
    }
}
