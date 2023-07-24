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
    @FXML private ToggleGroup group;

    @FXML
    private void switchToEnterQuestion() throws IOException {
        RadioButton selected = (RadioButton) group.getSelectedToggle();
        if (selected != null){
            if (selected.getId().equals(mc.getId())) {
                StartQuizzler.setDisplayType(DisplayType.MC);
                StartQuizzler.setRoot("enterQuestion");
            }
            if (selected.getId().equals(tf.getId())) {
                StartQuizzler.setDisplayType(DisplayType.TF);
                StartQuizzler.setRoot("enterQuestion");
            }
        } else {
            Alert alert = new Alert(AlertType.NONE, "Please select a Questiontype", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        }   
    }

    @FXML
    private void saveAndQuit() throws IOException{
        if (StartQuizzler.getNewQuiz().getQuestionsInt() == 0) {
            Alert alert = new Alert(AlertType.NONE, "Please add at least one question", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
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
                Alert alert = new Alert(AlertType.NONE, "Error: Quiz not added", ButtonType.OK);
                alert.showAndWait();

                if (alert.getResult() == ButtonType.OK) {
                    alert.close();
                }
            }
        }
    }

    @FXML
    private void quit() throws IOException {
        StartQuizzler.setRoot("menu");
    }

    
}
