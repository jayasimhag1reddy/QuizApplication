QuizApplication

Simple Quiz application. Where user can CRUD the questions and create the quiz from the pool of quesitons.

REST API's:

QuestionController:

getQuestions-> to get all questions.
getQuestions/category-> to get all question based on category.
addQuestion-> to add question
editQuestion/{id}->edit question based on id.
deleteQuestion/{id}->delete question based on id.

QuizController:
create->to create a quiz by specifing number of questions, Category and Title of the quiz.
getAllQuizzes-> to retrieve all quizzes.
getQuiz/{id}-> to get a specific quiz based on the quiz id.
Submit/{id}->calculate the score of the submitted quiz by specifing the quizID.

Room for improvement:You can add additional features to both QuestionController and QuizController.

TECH STACK:
Spring boot,
Spring JPA,
Spring hibernate,
PostGreSQL,
MAVEN
