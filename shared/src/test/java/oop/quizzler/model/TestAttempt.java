package oop.quizzler.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAttempt {
	@DisplayName("Test Attempt.get()")
	@Test
	void testGet() {
		assertEquals("Hello JUnit 5", Attempt.get());
	}
}
