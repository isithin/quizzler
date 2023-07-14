package oop.quizzler.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import oop.quizzler.model.Attempt;
import oop.quizzler.model.Connection;
import oop.quizzler.model.Question;
import oop.quizzler.model.Quiz;

public class AnswerQuestionController implements Initializable{
   //Views
    @FXML private ToggleGroup group;
    @FXML private RadioButton button1;
    @FXML private RadioButton button2;
    @FXML private RadioButton button3;
    @FXML private RadioButton button4; 
    @FXML private Label questionText;

    private Attempt attempt = StartQuizzler.getAttempt();
    private Quiz activeQuiz = StartQuizzler.getActiveQuiz();
    private Question question;

    @FXML
    private void nextQuestion() throws IOException {
        RadioButton selected = (RadioButton) group.getSelectedToggle();

        if (selected != null){
            if (selected.getText().equals(question.getCorrectAnswer())) {
                attempt.setScore(attempt.getScore()+1);
            }
        } else {
            Alert alert = new Alert(AlertType.NONE, "Please select an answer", ButtonType.OK);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        }


        if (attempt.getCount() < StartQuizzler.getActiveQuiz().getQuestionsInt()-1) {
            attempt.setCount(attempt.getCount()+1);
            StartQuizzler.setRoot("answerQuestion");
        } else {
            System.out.println("you done bitch");
            Connection connection = new Connection();
            connection.addHighscore(attempt, activeQuiz.getName());
            System.out.println("sollte hier drin stehen: " + connection.getQuizFromServer(activeQuiz.getName()).getAttempts());
            StartQuizzler.setRoot("viewScore");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        question = StartQuizzler.getActiveQuiz().getQuestions().get(attempt.getCount());

        button1.setText((question.getAnswers())[0]);
        button2.setText((question.getAnswers())[1]);
        button3.setText((question.getAnswers())[2]);
        button4.setText((question.getAnswers())[3]);
        questionText.setText(question.getQuestion());;
    }   

}
