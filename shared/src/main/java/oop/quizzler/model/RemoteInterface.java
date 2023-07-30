package oop.quizzler.model;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This interface is used to define the methods that are available to the
 * client.
 */
public interface RemoteInterface extends Remote {
	/**
	 * adds a quiz to the server
	 * 
	 * @param quiz quiz to be added
	 * @return returns true if the quiz was added successfully
	 * @throws RemoteException if the remote object is not available
	 */
	public boolean addQuiz(Quiz quiz) throws RemoteException;

	/**
	 * deletes a quiz from the server
	 * 
	 * @param name name of the quiz to be deleted
	 * @return returns true if the quiz was deleted successfully
	 * @throws RemoteException if the remote object is not available
	 */
	public boolean deleteQuiz(String name) throws RemoteException;

	/**
	 * gets a quiz from the server
	 * 
	 * @param name name of the quiz to be returned
	 * @return returns the quiz with the given name
	 * @throws RemoteException if the remote object is not available
	 */
	public Quiz getQuiz(String name) throws RemoteException;

	/**
	 * gets all quiznames from the server
	 * 
	 * @return returns all quiznames from the server in a String array
	 * @throws RemoteException if the remote object is not available
	 */
	public String[] getQuizzesString() throws RemoteException;

	/**
	 * adds a highscore to the quiz on the server
	 * 
	 * @param attempt attempt with score to be added
	 * @param name    name of the quiz to add the highscore to
	 * @throws RemoteException if the remote object is not available
	 */
	public void addHighscore(Attempt attempt, String name) throws RemoteException;
}
