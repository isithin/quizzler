package oop.quizzler.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
	 * Switches to the menu view. Establishes a connection to the local server.
	 * 
	 * @throws IOException
	 */
	@FXML
	private void switchToMenu() throws IOException {
		Connection connection = new Connection("127.0.0.1", 1099);
		InitQuizzler.setConnection(connection);
		InitQuizzler.setRoot("menu");
	}

	/**
	 * Switches to the enterIp view.
	 * 
	 * @throws IOException
	 */
	@FXML
	private void switchToEnterIp() throws IOException {
		InitQuizzler.setRoot("enterIp");
	}
}
