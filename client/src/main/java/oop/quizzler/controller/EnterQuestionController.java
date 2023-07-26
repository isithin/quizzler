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
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import oop.quizzler.model.Connection;
import oop.quizzler.model.DisplayType;
import oop.quizzler.model.MCQuestion;
import oop.quizzler.model.SCQuestion;
import oop.quizzler.model.TFQuestion;

public class EnterQuestionController implements Initializable{
    
    private ArrayList<String> correctAnswers = new ArrayList<String>();
    private DisplayType displayType = StartQuizzler.getDisplayType();
    private ToggleGroup group;

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
        if (DisplayType.MC == displayType) {
            addMCQuestionToQuiz();
        } else if (DisplayType.TF == displayType){
            addTFQuestionToQuiz();
        } else if (DisplayType.SC == displayType){
            addSCQuestionToQuiz();
        }
    }

    @FXML
    private void saveAndQuit() throws IOException{
        //test ob was angeklickt wurde fehlt noch
        if (DisplayType.MC == displayType) {
            addMCQuestionToQuiz();
        } else if (DisplayType.TF == displayType){
            addTFQuestionToQuiz();
        } else if (DisplayType.SC == displayType){
            addSCQuestionToQuiz();
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

    @FXML
    private void switchToSelectQuestionType() throws IOException {
        StartQuizzler.setRoot("selectQuestionType");
    }


    private void addMCQuestionToQuiz() throws IOException{

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
        if (correctAnswers.size() == 0 || answers[0].equals("") || answers[1].equals("") || answers[2].equals("") || answers[3].equals("") || questionText.equals("")) {
            alerting("Question not complete. Please fill out everything.");
        } else {
            MCQuestion question = new MCQuestion(questionText, answers, correctAnswers);
            StartQuizzler.getNewQuiz().setQuestion(question);
            //for debugging
            System.out.println("Question added "+StartQuizzler.getNewQuiz().getQuestions());
            StartQuizzler.setRoot("selectQuestionType");
        }
    }

    private void addTFQuestionToQuiz() throws IOException{
        correctAnswers.add(correctAnswerText.getText());
        String questionText = questionField.getText();
        if (correctAnswers.size() == 0 || questionText.equals("")) {
            alerting("Question not complete. Please make sure you entered a question and the correct answer.");
        } else {
            TFQuestion question = new TFQuestion(questionText, correctAnswers);
            StartQuizzler.getNewQuiz().setQuestion(question);
            //for debugging
            System.out.println("Question added "+StartQuizzler.getNewQuiz().getQuestions());
            StartQuizzler.setRoot("selectQuestionType");
        }
    }

    public void addSCQuestionToQuiz() throws IOException{
        RadioButton selected = (RadioButton) group.getSelectedToggle();
        correctAnswers.add(selected.getText());
        String questionText = questionField.getText();
        if (correctAnswers.size() == 0 || questionText.equals("")) {
            alerting("Question not complete. Please make sure you entered a question and selected the correct answer.");
        } else {
        SCQuestion question = new SCQuestion(questionText, correctAnswers);
        StartQuizzler.getNewQuiz().setQuestion(question);
        //for debugging
        System.out.println("Question added "+StartQuizzler.getNewQuiz().getQuestions()); 
        StartQuizzler.setRoot("selectQuestionType");
        }
    }

    public void alerting(String message) {
        Alert alert = new Alert(AlertType.NONE, message, ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
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
        } else if (displayType == DisplayType.TF) {
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
        } else if (displayType == DisplayType.SC) {
            group = new ToggleGroup();
            button1.setVisible(true);
            button2.setVisible(true);
            button1.setText("true");
            button2.setText("false");
            button1.setToggleGroup(group);
            button2.setToggleGroup(group);
            answer1.setVisible(false);
            answer2.setVisible(false);
            answer3.setVisible(false);
            answer4.setVisible(false);
            button3.setVisible(false);
            button4.setVisible(false);
            correctAnswerText.setVisible(false);
            description.setText("Please select the corrrect answer.");
        }
    }   
}
