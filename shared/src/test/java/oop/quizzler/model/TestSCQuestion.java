package oop.quizzler.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;

public class TestSCQuestion {
	String[] answers = { "true", "false" };

	ArrayList<String> correctAnswers = new ArrayList<>(Arrays.asList("true"));

	SCQuestion scQuestion = new SCQuestion("TestQuestion", correctAnswers);

	@DisplayName("Test SCQuestion.getQuestion()")
	@Test
	void testGetQuestion() {
		assertEquals("TestQuestion", scQuestion.getQuestion());
	}

	@DisplayName("Test SCQuestion.getCorrectAnswer()")
	@Test
	void testGetCorrectAnswer() {
		assertEquals(correctAnswers, scQuestion.getCorrectAnswer());
	}

	@DisplayName("Test SCQuestion.getDisplayType()")
	@Test
	void testGetDisplayType() {
		assertEquals(DisplayType.SC, scQuestion.getDisplayType());
	}

	@DisplayName("Test SCQuestion.checkAnswer()")
	@Test
	void testCheckAnswer() {
		ArrayList<String> givenAnswers = new ArrayList<>(Arrays.asList("true"));
		assertEquals(true, scQuestion.checkAnswer(givenAnswers));
	}
}
