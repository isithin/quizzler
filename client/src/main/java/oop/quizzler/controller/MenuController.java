package oop.quizzler.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * FXML Controller class for menu.fxml
 */
public class MenuController {

	// Views
	@FXML
	private Button play;

	@FXML
	private Button create;

	@FXML
	private Button back;

	/**
	 * @throws IOException Switches to the selectQuiz view.
	 */
	@FXML
	private void switchToSelectQuiz() throws IOException {
		InitQuizzler.setRoot("selectQuiz");
	}

	/**
	 * @throws IOException Switches to the namingQuiz view.
	 */
	@FXML
	private void switchToNamingQuiz() throws IOException {
		InitQuizzler.setRoot("namingQuiz");
	}

	/**
	 * @throws IOException Switches to the welcome view.
	 */
	@FXML
	private void switchToWelcome() throws IOException {
		InitQuizzler.setRoot("welcome");
	}
}
