package oop.quizzler.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class WelcomeController {
    //Views
    @FXML private Button localGame;
    @FXML private Button joinGame;
    
    @FXML
    private void switchToMenu() throws IOException {
        StartQuizzler.setRoot("menu");
    }

    @FXML
    private void switchToEnterIp() throws IOException {
        StartQuizzler.setRoot("enterIp");
    }
}
