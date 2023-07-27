package oop.quizzler.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * FXML Controller class for menu.fxml
 */
public class MenuController {

    //Views
    @FXML private Button play;
    @FXML private Button create;
    @FXML private Button back;
    
    @FXML
    private void switchToSelectQuiz() throws IOException {
        InitQuizzler.setRoot("selectQuiz");
    }

    @FXML
    private void switchToNamingQuiz() throws IOException {
        InitQuizzler.setRoot("namingQuiz");
    }

    @FXML
    private void switchToWelcome() throws IOException {
        InitQuizzler.setRoot("welcome");
    }

}
