package oop.quizzler.controller;

import java.io.IOException;
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
import javafx.scene.control.Alert.AlertType;
import oop.quizzler.model.Connection;
import oop.quizzler.model.DisplayType;
import oop.quizzler.model.MCQuestion;
import oop.quizzler.model.TFQuestion;

public class EnterQuestionController implements Initializable{
    
    private ArrayList<String> correctAnswers = new ArrayList<String>();
    private DisplayType displayType = StartQuizzler.getDisplayType();

    //Views
    @FXML private TextField answer1;
    @FXML private TextField answer2;
    @FXML private TextField answer3;
    @FXML private TextField answer4;
    @FXML private TextField correctAnswerText;
    @FXML private TextField questionField;
    @FXML private RadioButton button1;
    @FXML private RadioButton button2;
    @FXML private RadioButton button3;
    @FXML private RadioButton button4;
    @FXML private Label description;

    @FXML
    private void createMore() throws IOException{
        //test ob was angeklickt wurde fehlt noch
        if (DisplayType.MC == displayType) {
            addMCQuestionToQuiz();
        } else if (DisplayType.TF == displayType){
            addTFQuestionToQuiz();
        } else {
            System.out.println("Error: DisplayType not set");
        }
        StartQuizzler.setRoot("selectQuestionType");
    }

    @FXML
    private void saveAndQuit() throws IOException{
        //test ob was angeklickt wurde fehlt noch
        if (DisplayType.MC == displayType) {
            addMCQuestionToQuiz();
        } else if (DisplayType.TF == displayType){
            addTFQuestionToQuiz();
        } else {
            System.out.println("Error: DisplayType not set");
        }
    
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
    }

    private void addMCQuestionToQuiz() {

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
        //i guess we want to generate custom exceptions for this (otherwise the "selectQuestionType" window will load)
        if (correctAnswers.size() == 0) {
            Alert alert = new Alert(AlertType.NONE, "Please select at least one correct answer", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        } else if (answers[0].equals("") || answers[1].equals("") || answers[2].equals("") || answers[3].equals("")) {
            Alert alert = new Alert(AlertType.NONE, "Please enter all answers", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        } else if (questionText.equals("")) {
            Alert alert = new Alert(AlertType.NONE, "Please enter a question", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        } else {
            MCQuestion question = new MCQuestion(questionText, answers, correctAnswers);
            StartQuizzler.getNewQuiz().setQuestion(question);
            System.out.println("Question added "+StartQuizzler.getNewQuiz().getQuestions());
        }
    }

    private void addTFQuestionToQuiz() {
        correctAnswers.add(correctAnswerText.getText());
        String questionText = questionField.getText();
        //custom exceptions here also?
        if (correctAnswers.size() == 0) {
            Alert alert = new Alert(AlertType.NONE, "Please enter a correct answer", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        } else if (questionText.equals("")) {
            Alert alert = new Alert(AlertType.NONE, "Please enter a question", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        } else {
            TFQuestion question = new TFQuestion(questionText, correctAnswers);
            StartQuizzler.getNewQuiz().setQuestion(question);
            System.out.println("Question added "+StartQuizzler.getNewQuiz().getQuestions());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (displayType == DisplayType.MC) {
            answer1.setVisible(true);
            answer2.setVisible(true);
            answer3.setVisible(true);
            answer4.setVisible(true);
            button1.setVisible(true);
            button2.setVisible(true);
            button3.setVisible(true);
            button4.setVisible(true);
            correctAnswerText.setVisible(false);
            description.setText("Please enter possible answers and select the correct answers.");
        } else {
            answer1.setVisible(false);
            answer2.setVisible(false);
            answer3.setVisible(false);
            answer4.setVisible(false);
            button1.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
            button4.setVisible(false);
            correctAnswerText.setVisible(true);
            description.setText("Please enter the corrrect answer.");
        }

        
    }   
}
