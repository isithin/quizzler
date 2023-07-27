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

/**
 * FXML Controller class for enterQuestion.fxml
 */
public class EnterQuestionController implements Initializable{
    
    private ArrayList<String> correctAnswers = new ArrayList<String>();
    private DisplayType displayType = InitQuizzler.getDisplayType();
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
            if (addMCQuestionToQuiz()) {
                InitQuizzler.setRoot("selectQuestionType");
            } else {
                alerting("Question not complete.\nPlease fill out everything.");
            }
        } else if (DisplayType.TF == displayType){
            if (addTFQuestionToQuiz()) {
                InitQuizzler.setRoot("selectQuestionType");
            } else {
                alerting("Question not complete.\nPlease make sure you entered a \nquestion and the correct answer.");
            }
        } else if (DisplayType.SC == displayType){
            if (addSCQuestionToQuiz()) {
                InitQuizzler.setRoot("selectQuestionType");
            } else {
                alerting("Question not complete.\nPlease make sure you entered a \nquestion and selected the correct answer.");
            }
        }
    }

    @FXML
    private void saveAndQuit() throws IOException{
        if (DisplayType.MC == displayType) {
            if (addMCQuestionToQuiz()) {
                pushQuizToServer();
            } else {
                alerting("Question not complete.\nPlease fill out everything.");
            }
        } else if (DisplayType.TF == displayType){
            if (addTFQuestionToQuiz()) {
                pushQuizToServer();
            } else {
                alerting("Question not complete.\nPlease make sure you entered a \nquestion and the correct answer.");
            }
        } else if (DisplayType.SC == displayType){
            if (addSCQuestionToQuiz()) {
                pushQuizToServer();
            } else {
                alerting("Question not complete.\nPlease make sure you entered a \nquestion and selected the correct answer.");
            }
        }
    }

    @FXML
    private void switchToSelectQuestionType() throws IOException {
        InitQuizzler.setRoot("selectQuestionType");
    }

    private boolean addMCQuestionToQuiz() {
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
            return false;
        }
        MCQuestion question = new MCQuestion(questionText, answers, correctAnswers);
        InitQuizzler.getNewQuiz().setQuestion(question);
        //for debugging
        System.out.println("Question added "+InitQuizzler.getNewQuiz().getQuestions());
        return true;            
    }

    private boolean addTFQuestionToQuiz() throws IOException{
        correctAnswers.add(correctAnswerText.getText());
        String questionText = questionField.getText();
        if (correctAnswers.size() == 0 || questionText.equals("")) {
            return false;
        }
        TFQuestion question = new TFQuestion(questionText, correctAnswers);
        InitQuizzler.getNewQuiz().setQuestion(question);
        //for debugging
        System.out.println("Question added "+InitQuizzler.getNewQuiz().getQuestions());
        return true;
    }

    
    /**
     * @return
     * Adds the selected answer to the question and adds the question to the quiz
     */
    public boolean addSCQuestionToQuiz() {
        RadioButton selected = (RadioButton) group.getSelectedToggle();
        if (selected == null) {
            return false;
        }
        correctAnswers.add(selected.getText());
        String questionText = questionField.getText();
        SCQuestion question = new SCQuestion(questionText, correctAnswers);
        InitQuizzler.getNewQuiz().setQuestion(question);
        //for debugging
        System.out.println("Question added "+InitQuizzler.getNewQuiz().getQuestions()); 
        return true;
    }

    /**
     * @param message
     * Here to avoid code duplication
     */
    public void alerting(String message) {
        Alert alert = new Alert(AlertType.NONE, message, ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
    }

    /**
     * @throws IOException
     * Pushes the quiz to the server
     */
    public void pushQuizToServer() throws IOException{
        Connection connection = InitQuizzler.getConnection();
        if (connection.addQuizToServer(InitQuizzler.getNewQuiz())) {
            Alert alert = new Alert(AlertType.NONE, "Quiz added", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
                InitQuizzler.setRoot("menu");
            }
        } else {
            Alert alert = new Alert(AlertType.NONE, "Error: Quiz not added", ButtonType.OK);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        }
}

    /**
     * @param url
     * @param rb
     * Sets the initial view according to the displayType
     */
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
