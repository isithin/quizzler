package oop.quizzler.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import oop.quizzler.model.Connection;

public class WelcomeController {
    //Views
    @FXML private Button localGame;
    @FXML private Button joinGame;
    
    @FXML
    private void switchToMenu() throws IOException {
        Connection connection = new Connection("127.0.0.1", 1099);
        InitQuizzler.setConnection(connection);
        InitQuizzler.setRoot("menu");
    }

    @FXML
    private void switchToEnterIp() throws IOException {
        InitQuizzler.setRoot("enterIp");
    }
}
