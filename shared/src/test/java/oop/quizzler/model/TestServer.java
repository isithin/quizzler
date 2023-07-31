package oop.quizzler.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class TestServer {
	@Mock
	Server server = Mockito.mock(Server.class);

	Attempt attempt = Mockito.mock(Attempt.class);

	Quiz quiz = new Quiz("TestQuiz");

	@DisplayName("Test Server.addQuiz()")
	@Test
	void testAddQuiz() {
		server.addQuiz(quiz);
		Mockito.verify(server).addQuiz(quiz);
	}

	@DisplayName("Test Server.getQuiz()")
	@Test
	void testGetQuiz() {
		server.addQuiz(quiz);
		server.getQuiz("TestQuiz");
		Mockito.verify(server).getQuiz("TestQuiz");
	}

	@DisplayName("Test Server.deleteQuiz()")
	@Test
	void testDeleteQuiz() {
		server.addQuiz(quiz);
		server.deleteQuiz("TestQuiz");
		Mockito.verify(server).deleteQuiz("TestQuiz");
	}

	@DisplayName("Test Server.getQuizzesString()")
	@Test
	void testGetQuizzesString() {
		server.addQuiz(quiz);
		server.getQuizzesString();
		Mockito.verify(server).addQuiz(quiz);
		Mockito.verify(server).getQuizzesString();
	}

	@DisplayName("Test Server.addHighscore()")
	@Test
	void testAddHighscore() {
		server.addHighscore(attempt, "TestQuiz");
		Mockito.verify(server).addHighscore(attempt, "TestQuiz");
	}
}
