package oop.quizzler.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import oop.quizzler.model.Connection;
import javafx.scene.control.Alert.AlertType;

/**
 * FXML Controller class for enterIp.fxml
 */
public class EnterIpController {
	// Views
	@FXML
	private TextField ip;

	private int standardPort;

	private Connection connection;

	/**
	 * Switches to the welcome view.
	 * 
	 * @throws IOException if the view cannot be found
	 */
	@FXML
	private void switchToWelcome() throws IOException {
		InitQuizzler.setRoot("welcome");
	}

	/**
	 * Establishes a connection to the server. If the connection fails, an alert is
	 * shown. If the connection succeeds, the connection is saved in the
	 * InitQuizzler class and the menu view is shown.
	 * 
	 * @throws IOException if the view cannot be found
	 */
	@FXML
	private void establishConnection() throws IOException {
		if (((ip.getText()).length() == 0)) {
			Alert alert = new Alert(AlertType.NONE, "Please enter a IP", ButtonType.OK);
			alert.showAndWait();
			if (alert.getResult().equals(ButtonType.OK)) {
				alert.close();
			}
		} else {
			connection = new Connection(ip.getText(), standardPort);
			InitQuizzler.setConnection(connection);
		}
		if (connection.getRemoteInterface() == null) {
			Alert alert = new Alert(AlertType.NONE, "Connection failed, please try again", ButtonType.OK);
			alert.showAndWait();
			if (alert.getResult().equals(ButtonType.OK)) {
				alert.close();
			}
		} else {
			InitQuizzler.setRoot("menu");
		}
	}
}
