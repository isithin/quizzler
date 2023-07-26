package oop.quizzler.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import oop.quizzler.model.Connection;
import oop.quizzler.model.DisplayType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class SelectQuestionTypeController {

    //Views
    @FXML private RadioButton mc;
    @FXML private RadioButton tf;
    @FXML private RadioButton sc;
    @FXML private ToggleGroup group;

    @FXML
    private void switchToEnterQuestion() throws IOException {
        RadioButton selected = (RadioButton) group.getSelectedToggle();
        if (selected != null){
            if (selected.getId().equals(mc.getId())) {
                StartQuizzler.setDisplayType(DisplayType.MC);
            }
            if (selected.getId().equals(tf.getId())) {
                StartQuizzler.setDisplayType(DisplayType.TF);
            }
            if (selected.getId().equals(sc.getId())) {
                StartQuizzler.setDisplayType(DisplayType.SC);
            }
            StartQuizzler.setRoot("enterQuestion");
        } else {
           alerting("Please select a Questiontype");
        }   
    }

    @FXML
    private void saveAndQuit() throws IOException{
        if (StartQuizzler.getNewQuiz().getQuestionsInt() == 0) {
            alerting("Please add at least one question");
        } else {
            Connection connection = StartQuizzler.getConnection();
            if (connection.addQuizToServer(StartQuizzler.getNewQuiz())) {
                Alert alert = new Alert(AlertType.NONE, "Quiz added", ButtonType.OK);
                alert.showAndWait();

                if (alert.getResult() == ButtonType.OK) {
                    alert.close();
                    StartQuizzler.setRoot("menu");
                }
            } else {
                alerting("Error: Quiz not added");
            }
        }
    }

    @FXML
    private void quit() throws IOException {
        StartQuizzler.setRoot("menu");
    }

    public void alerting(String message) {
        Alert alert = new Alert(AlertType.NONE, message, ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
    }

    
}
