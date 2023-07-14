package oop.quizzler.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import oop.quizzler.model.Question;
import oop.quizzler.model.Connection;

public class EnterQuestionController{
    
    private String correctAnswer;
   
    //Views
    @FXML private ToggleGroup group;
    @FXML private TextField answer1;
    @FXML private TextField answer2;
    @FXML private TextField answer3;
    @FXML private TextField answer4;
    @FXML private TextField questionField;
    
    

    @FXML
    private void createMore() throws IOException{
        addQuestionToQuiz();
        System.out.println("added");
        StartQuizzler.setRoot("enterQuestion");

    }

    @FXML
    private void saveAndQuit() throws IOException{
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
        RadioButton selected = (RadioButton) group.getSelectedToggle();
        System.out.println(selected.getId());
        switch (selected.getId()) {
            case "button1":
                correctAnswer = answer1.getText();
                break;
            case "button2":
                correctAnswer = answer2.getText();
                break;
            case "button3":
                correctAnswer = answer3.getText();
                break;
            case "button4":
                correctAnswer = answer4.getText();
                break;
            default:
                break;
        }
        System.out.println(correctAnswer);

        String[] answers = {answer1.getText(), answer2.getText(), answer3.getText(), answer4.getText()};
        String questionText = questionField.getText();
        Question question = new Question(questionText, answers, correctAnswer);
        StartQuizzler.getNewQuiz().setQuestion(question);
        System.out.println("Question added "+StartQuizzler.getNewQuiz().getQuestions());
    }

}
