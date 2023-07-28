package oop.quizzler.model;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This interface is used to define the methods that are available to the
 * client.
 */
public interface RemoteInterface extends Remote {
	/**
	 * @param quiz
	 * @return
	 * @throws RemoteException adds a quiz to the server
	 */
	public boolean addQuiz(Quiz quiz) throws RemoteException;

	/**
	 * @param name
	 * @return
	 * @throws RemoteException deletes a quiz from the server
	 */
	public boolean deleteQuiz(String name) throws RemoteException;

	/**
	 * @param name
	 * @return
	 * @throws RemoteException gets a quiz from the server
	 */
	public Quiz getQuiz(String name) throws RemoteException;

	/**
	 * @return
	 * @throws RemoteException gets all quiznames from the server
	 */
	public String[] getQuizzesString() throws RemoteException;

	/**
	 * @param attempt
	 * @param name
	 * @throws RemoteException adds a highscore to the quiz on the server
	 */
	public void addHighscore(Attempt attempt, String name) throws RemoteException;
}
