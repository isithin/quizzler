package oop.quizzler.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;

public class TestTFQuestions {
	ArrayList<String> correctAnswers = new ArrayList<>(Arrays.asList("testAnswer"));

	TFQuestion tfQuestion = new TFQuestion("TestQuestion", correctAnswers);

	@DisplayName("Test TFQuestion.getQuestion()")
	@Test
	void testGetQuestion() {
		assertEquals("TestQuestion", tfQuestion.getQuestion());
	}

	@DisplayName("Test TFQuestion.getCorrectAnswer()")
	@Test
	void testGetCorrectAnswer() {
		assertEquals(correctAnswers, tfQuestion.getCorrectAnswer());
	}

	@DisplayName("Test TFQuestion.getDisplayType()")
	@Test
	void testGetDisplayType() {
		assertEquals(DisplayType.TF, tfQuestion.getDisplayType());
	}

	@DisplayName("Test TFQuestion.checkAnswer()")
	@Test
	void testCheckAnswer() {
		ArrayList<String> givenAnswers = new ArrayList<>(Arrays.asList("testAnswer"));
		assertEquals(true, tfQuestion.checkAnswer(givenAnswers));
	}
}
