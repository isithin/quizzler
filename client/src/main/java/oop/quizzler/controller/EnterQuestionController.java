package oop.quizzler.controller;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import oop.quizzler.model.Question;
import oop.quizzler.model.Connection;

public class EnterQuestionController{
    
    private ArrayList<String> correctAnswers = new ArrayList<String>();
   
    //Views
    @FXML private TextField answer1;
    @FXML private TextField answer2;
    @FXML private TextField answer3;
    @FXML private TextField answer4;
    @FXML private TextField questionField;
    @FXML private RadioButton button1;
    @FXML private RadioButton button2;
    @FXML private RadioButton button3;
    @FXML private RadioButton button4;

    @FXML
    private void createMore() throws IOException{
        //test ob was angeklickt wurde
        addQuestionToQuiz();
        System.out.println("added");
        StartQuizzler.setRoot("enterQuestion");

    }

    @FXML
    private void saveAndQuit() throws IOException{
        //test ob was angeklickt wurde
        addQuestionToQuiz();
        Connection connection = StartQuizzler.getConnection();
        if (connection.addQuizToServer(StartQuizzler.getNewQuiz())) {
            Alert alert = new Alert(AlertType.NONE, "Quiz added", ButtonType.OK);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.OK) {
                alert.close();
                StartQuizzler.setRoot("menu");
            }
        } else {
            Alert alert = new Alert(AlertType.NONE, "Error: Quiz not added", ButtonType.OK);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        };
        System.out.println("Quizzes added: "+connection.getQuizFromServer("test"));
    }

    private void addQuestionToQuiz() {

        if (button1.isSelected()) {
            correctAnswers.add(answer1.getText());
        }
        if (button2.isSelected()) {
            correctAnswers.add(answer2.getText());
        }
        if (button3.isSelected()) {
            correctAnswers.add(answer3.getText());
        }
        if (button4.isSelected()) {
            correctAnswers.add(answer4.getText());        
        }
        String[] answers = {answer1.getText(), answer2.getText(), answer3.getText(), answer4.getText()};
        String questionText = questionField.getText();
        Question question = new Question(questionText, answers, correctAnswers);
        StartQuizzler.getNewQuiz().setQuestion(question);
        System.out.println("Question added "+StartQuizzler.getNewQuiz().getQuestions());
    }
}
