package com.jay.QuizApp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class QuestionWrapper {
    private Integer id;
    private String question;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
}
