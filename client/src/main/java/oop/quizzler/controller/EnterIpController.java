package oop.quizzler.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import oop.quizzler.model.Connection;
import javafx.scene.control.Alert.AlertType;

public class EnterIpController {
    //Views
    @FXML private TextField ip;
    @FXML private TextField port;

    private Connection connection;

    @FXML
    private void switchToWelcome() throws IOException {
        StartQuizzler.setRoot("welcome");
    }

    @FXML
    private void establishConnection() throws IOException{
        if (((ip.getText()).length() == 0)||((port.getText()).length() == 0)) {
            Alert alert = new Alert(AlertType.NONE, "Please enter IP and Port", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        } else {
                connection = new Connection(ip.getText(), Integer.parseInt(port.getText()));
                StartQuizzler.setConnection(connection);
        }
        if (connection.getRemoteInterface() == null) {
            Alert alert = new Alert(AlertType.NONE, "Connection failed, please try again", ButtonType.OK);
            alert.showAndWait();
        } else {
            StartQuizzler.setRoot("selectQuiz");
        }
    }
}
