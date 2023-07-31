package oop.quizzler.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;

public class TestQuiz {
	Quiz quiz = new Quiz("TestQuiz");

	String[] answers = { "answer1", "answer2", "answer3", "answer4" };

	ArrayList<String> correctAnswers = new ArrayList<>(Arrays.asList("answer1", "answer2"));

	MCQuestion mcQuestion = new MCQuestion("TestQuestion", answers, correctAnswers);

	@DisplayName("Test Quiz.getName()")
	@Test
	void testGetName() {
		assertEquals("TestQuiz", quiz.getName());
	}

	@DisplayName("Test Quiz.setQuestion()")
	@Test
	void testSetQuestion() {
		quiz.setQuestion(mcQuestion);
		assertEquals(mcQuestion, quiz.getQuestions().get(0));
	}

	@DisplayName("Test Quiz.getQuestions()")
	@Test
	void testGetQuestions() {
		quiz.setQuestion(mcQuestion);
		assertEquals(mcQuestion, quiz.getQuestions().get(0));
	}

	@DisplayName("Test Quiz.getQuestionsInt()")
	@Test
	void testGetQuestionsInt() {
		quiz.setQuestion(mcQuestion);
		assertEquals(1, quiz.getQuestionsInt());
	}

	@DisplayName("Test Quiz.setAttempt()")
	@Test
	void testSetAttempt() {
		Attempt attempt = new Attempt("test", quiz);
		quiz.setAttempt(attempt);
		assertEquals(attempt, quiz.getAttempts().get(0));
	}

	@DisplayName("Test Quiz.getAttempts()")
	@Test
	void testGetAttempts() {
		Attempt attempt = new Attempt("test", quiz);
		quiz.setAttempt(attempt);
		assertEquals(attempt, quiz.getAttempts().get(0));
	}
}
