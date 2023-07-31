package oop.quizzler.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;

public class TestMCQuestion {
	String[] answers = { "answer1", "answer2", "answer3", "answer4" };

	ArrayList<String> correctAnswers = new ArrayList<>(Arrays.asList("answer1", "answer2"));

	MCQuestion mcQuestion = new MCQuestion("TestQuestion", answers, correctAnswers);

	@DisplayName("Test MCQuestion.getQuestion()")
	@Test
	void testGetQuestion() {
		assertEquals("TestQuestion", mcQuestion.getQuestion());
	}

	@DisplayName("Test MCQuestion.getCorrectAnswer()")
	@Test
	void testGetCorrectAnswer() {
		assertEquals(correctAnswers, mcQuestion.getCorrectAnswer());
	}

	@DisplayName("Test MCQuestion.getDisplayType()")
	@Test
	void testGetDisplayType() {
		assertEquals(DisplayType.MC, mcQuestion.getDisplayType());
	}

	@DisplayName("Test MCQuestion.getAnswers()")
	@Test
	void testGetAnswers() {
		assertEquals(answers, mcQuestion.getAnswers());
	}

	@DisplayName("Test MCQuestion.checkAnswer()")
	@Test
	void testCheckAnswer() {
		ArrayList<String> givenAnswers = new ArrayList<>(Arrays.asList("answer1", "answer2"));
		assertEquals(true, mcQuestion.checkAnswer(givenAnswers));
	}
}
