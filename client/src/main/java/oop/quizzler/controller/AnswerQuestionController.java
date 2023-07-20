package oop.quizzler.controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import oop.quizzler.model.Attempt;
import oop.quizzler.model.Connection;
import oop.quizzler.model.DisplayType;
import oop.quizzler.model.Question;
import oop.quizzler.model.MCQuestion;
import oop.quizzler.model.Quiz;

public class AnswerQuestionController implements Initializable{
   //Views
    @FXML private ToggleGroup group;
    @FXML private RadioButton button1;
    @FXML private RadioButton button2;
    @FXML private RadioButton button3;
    @FXML private RadioButton button4; 
    @FXML private TextField answerText;
    @FXML private Label questionText;

    private Attempt attempt = StartQuizzler.getAttempt();
    private Quiz activeQuiz = StartQuizzler.getActiveQuiz();
    private Question question;
    private ArrayList<String> answer = new ArrayList<String>();

    @FXML
    private void nextQuestion() throws IOException {
        collectAnswers(question.getDisplayType());
        if (answer != null){
            if (question.checkAnswer(answer)) {
                attempt.setScore(attempt.getScore()+1);
            }
            /* 
            if (answer.equals(question.getCorrectAnswer())) {
                attempt.setScore(attempt.getScore()+1);
            }
            */
        } else {
            Alert alert = new Alert(AlertType.NONE, "Please answer", ButtonType.OK);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        }

        if (attempt.getCount() < StartQuizzler.getActiveQuiz().getQuestionsInt()-1) {
            attempt.setCount(attempt.getCount()+1);
            StartQuizzler.setRoot("answerQuestion");
        } else {
            Connection connection = StartQuizzler.getConnection();
            connection.addHighscore(attempt, activeQuiz.getName());
            StartQuizzler.setRoot("viewScore");
        }
    }

    private void collectAnswers(DisplayType displayType) {
        if (displayType.equals(DisplayType.TF)) {
            answer.add(answerText.getText());
        } else if (displayType.equals(DisplayType.MC)) {
            if (button1.isSelected()) {
                answer.add(button1.getText());
            }
            if (button2.isSelected()) {
                answer.add(button2.getText());
            }
            if (button3.isSelected()) {
                answer.add(button3.getText());
            }
            if (button4.isSelected()) {
                answer.add(button4.getText());        
            }
        } else {
            System.out.println("Gibts nicht");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        question = StartQuizzler.getActiveQuiz().getQuestions().get(attempt.getCount());

        if (question.getDisplayType().equals(DisplayType.MC)) {
            button1.setText((((MCQuestion) question).getAnswers())[0]);
            button2.setText((((MCQuestion) question).getAnswers())[1]);
            button3.setText((((MCQuestion) question).getAnswers())[2]);
            button4.setText((((MCQuestion) question).getAnswers())[3]);
            questionText.setText(question.getQuestion());
            button1.setVisible(true);
            button2.setVisible(true);
            button3.setVisible(true);
            button4.setVisible(true);
            answerText.setVisible(false);

        } else if (question.getDisplayType().equals(DisplayType.TF)) {
            questionText.setText(question.getQuestion());
            button1.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
            button4.setVisible(false);
            answerText.setVisible(true);

        } else {
            System.out.println("Gibts nicht");
        }

        
    }   

}
