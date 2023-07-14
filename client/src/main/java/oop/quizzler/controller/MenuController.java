package oop.quizzler.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

    //Views
    @FXML private Button play;
    @FXML private Button create;
    
    @FXML
    private void switchToSelectQuiz() throws IOException {
        StartQuizzler.setRoot("selectQuiz");
    }

    @FXML
    private void switchToNamingQuiz() throws IOException {
        StartQuizzler.setRoot("namingQuiz");
    }
}
