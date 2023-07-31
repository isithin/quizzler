package oop.quizzler.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAttempt {
	@DisplayName("Test Attempt.getScore()")
	@Test
	void testGetScore() {
		Quiz quiz = new Quiz("TestQuiz");
		Attempt attempt = new Attempt("test", quiz);
		attempt.setScore(10);
		assertEquals(10, attempt.getScore());
	}

	@DisplayName("Test Attempt.setScore()")
	@Test
	void testSetScore() {
		Quiz quiz = new Quiz("TestQuiz");
		Attempt attempt = new Attempt("test", quiz);
		attempt.setScore(10);
		assertEquals(10, attempt.getScore());
	}

	@DisplayName("Test Attempt.getCount()")
	@Test
	void testGetCount() {
		Quiz quiz = new Quiz("TestQuiz");
		Attempt attempt = new Attempt("test", quiz);
		attempt.setCount(10);
		assertEquals(10, attempt.getCount());
	}

	@DisplayName("Test Attempt.setCount()")
	@Test
	void testSetCount() {
		Quiz quiz = new Quiz("TestQuiz");
		Attempt attempt = new Attempt("test", quiz);
		attempt.setCount(10);
		assertEquals(10, attempt.getCount());
	}

	@DisplayName("Test Attempt.getActiveQuiz()")
	@Test
	void testGetActiveQuiz() {
		Quiz quiz = new Quiz("TestQuiz");
		Attempt attempt = new Attempt("test", quiz);
		assertEquals(quiz, attempt.getActiveQuiz());
	}

	@DisplayName("Test Attempt.setActiveQuiz()")
	@Test
	void testSetActiveQuiz() {
		Quiz quiz = new Quiz("TestQuiz");
		Attempt attempt = new Attempt("test", quiz);
		Quiz quiz2 = new Quiz("TestQuiz2");
		attempt.setActiveQuiz(quiz2);
		assertEquals(quiz2, attempt.getActiveQuiz());
	}

	@DisplayName("Test Attempt.getUsername()")
	@Test
	void testGetUsername() {
		Quiz quiz = new Quiz("TestQuiz");
		Attempt attempt = new Attempt("test", quiz);
		assertEquals("test", attempt.getUsername());
	}

	@DisplayName("Test Attempt.setUsername()")
	@Test
	void testSetUsername() {
		Quiz quiz = new Quiz("TestQuiz");
		Attempt attempt = new Attempt("test", quiz);
		attempt.setUsername("test2");
		assertEquals("test2", attempt.getUsername());
	}

	@DisplayName("Test Attempt.compareTo()")
	@Test
	void testCompareTo() {
		Quiz quiz = new Quiz("TestQuiz");
		Attempt attempt = new Attempt("test", quiz);
		Attempt attempt2 = new Attempt("test2", quiz);
		attempt.setScore(10);
		attempt2.setScore(20);
		assertEquals(10, attempt.compareTo(attempt2));
	}
}
