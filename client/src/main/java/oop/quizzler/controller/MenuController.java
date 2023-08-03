package oop.quizzler.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class for menu.fxml
 */
public class MenuController implements Initializable {

	// Views
	@FXML
	private Button play;

	@FXML
	private Button create;

	@FXML
	private Button back;

	@FXML
	private Label serverInfo;

	/**
	 * Switches to the selectQuiz view.
	 * 
	 * @throws IOException if the view cannot be found
	 */
	@FXML
	private void switchToSelectQuiz() throws IOException {
		InitQuizzler.setRoot("selectQuiz");
	}

	/**
	 * Switches to the namingQuiz view.
	 * 
	 * @throws IOException if the view cannot be found
	 */
	@FXML
	private void switchToNamingQuiz() throws IOException {
		InitQuizzler.setRoot("namingQuiz");
	}

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
	 * Initializes the view. Gets the IP of the server and displays it. (makes it
	 * easy to share the IP with other players)
	 * 
	 * @param url not used but required
	 * @param rb  not used but required
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		serverInfo.setText("Connected to IP: " + InitQuizzler.getConnection().getIp());
	}
}
