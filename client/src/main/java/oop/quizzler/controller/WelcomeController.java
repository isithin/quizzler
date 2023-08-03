package oop.quizzler.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import oop.quizzler.model.Connection;

/**
 * FXML Controller class for welcome.fxml. First view of the application.
 */
public class WelcomeController {
	// Views
	@FXML
	private Button localGame;

	@FXML
	private Button joinGame;

	/**
	 * Switches to the menu view. Starts the local server and establishes a
	 * connection. The connection is saved in the InitQuizzler class. If the server
	 * is already running, the menu view is shown. If the server start fails, an
	 * alert is shown.
	 * 
	 * 
	 * @throws IOException if the view cannot be found
	 */
	@FXML
	private void switchToMenu() {
		try {
			String ip = StartServer.start();
			if (ip != null && InitQuizzler.getConnection() == null) {
				Connection connection = new Connection(ip, 1099);
				InitQuizzler.setConnection(connection);
				InitQuizzler.setRoot("menu");
			} else if (ip == null && InitQuizzler.getConnection() != null) {
				InitQuizzler.setRoot("menu");
			} else if (ip == null && InitQuizzler.getConnection() == null) {
				Alert alert = new Alert(Alert.AlertType.NONE, "Server start failed", ButtonType.OK);
				alert.showAndWait();
				if (alert.getResult().equals(ButtonType.OK)) {
					alert.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Switches to the enterIp view.
	 * 
	 * @throws IOException if the view cannot be found
	 */
	@FXML
	private void switchToEnterIp() throws IOException {
		InitQuizzler.setRoot("enterIp");
	}
}
