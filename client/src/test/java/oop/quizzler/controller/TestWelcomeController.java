package oop.quizzler.controller;

import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * TestWelcomeController
 */
public class TestWelcomeController extends ApplicationTest {
	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("welcome.fxml"));
		Scene scene;
		stage.setScene(scene = new Scene(loader.load(), 300, 300));
		stage.show();
	}

	@Test
	public void testWelcomeController() {
		FxAssert.verifyThat("#switchToMenu", LabeledMatchers.hasText("Local Gamerrr"));
	}
}
