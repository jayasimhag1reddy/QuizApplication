QuizApplication

Simple Quiz application. Where user can CRUD the questions and create the quiz from the pool of quesitons.

REST API's:

QuestionController:

1)getQuestions-> to get all questions
2)getQuestions/category-> to get all question based on category.
3)addQuestion-> to add question
4)editQuestion/{id}->edit question based on id.
5)deleteQuestion/{id}->delete question based on id.

QuizController:
1)create->to create a quiz by specifing number of questions, Category and Title of the quiz.
2)getAllQuizzes-> to retrieve all quizzes.
3)getQuiz/{id}-> to get a specific quiz based on the quiz id.
4)Submit/{id}->calculate the score of the submitted quiz by specifing the quizID.

Room for improvement:You can add additional features to both QuestionController and QuizController.

TECH STACK:
Spring boot,
Spring JPA,
Spring hibernate,
PostGreSQL,
MAVEN
