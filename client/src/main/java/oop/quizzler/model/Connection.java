package oop.quizzler.model;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Class that represents a connection to the server.
 */
public class Connection {
	private RemoteInterface remoteInterface;

	private final String ip;

	private final int port;

	/**
	 * @param ip
	 * @param port Establishes a connection to the server on call and sets the
	 *             remoteInterface Object.
	 */
	public Connection(String ip, int port) {
		this.ip = ip;
		this.port = port;
		this.remoteInterface = getConnection();
	}

	/**
	 * @return Establishes a connection to the server and returns the
	 *         remoteInterface Object.
	 */
	public RemoteInterface getConnection() {
		try {
			Registry reg = LocateRegistry.getRegistry(ip, port);
			remoteInterface = (RemoteInterface) reg.lookup("Quizzler");
			// for debugging
			System.out.println("Connected.");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return remoteInterface;
	}

	/**
	 * @return Returns the remoteInterface Object.
	 */
	public RemoteInterface getRemoteInterface() {
		return this.remoteInterface;
	}

	/**
	 * @param newquiz
	 * @return Adds a given new quiz to the server. Uses the remoteInterface Object.
	 */
	public boolean addQuizToServer(Quiz newquiz) {
		try {
			return remoteInterface.addQuiz(newquiz);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @param name
	 * @return Deletes a quiz from the server. The quiz is identified by its name.
	 *         Uses the remoteInterface Object.
	 */
	public boolean deleteQuizFromServer(String name) {
		try {
			return remoteInterface.deleteQuiz(name);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @param name
	 * @return Returns a quiz from the server. The quiz is identified by its name.
	 *         Uses the remoteInterface Object.
	 */
	public Quiz getQuizFromServer(String name) {
		try {
			return remoteInterface.getQuiz(name);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @return Returns all quiznames from the server in a String array.
	 */
	public String[] getAllQuizNamesFromServer() {
		try {
			return remoteInterface.getQuizzesString();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param attempt
	 * @param name    Adds a highscore to the server. The highscore is located in
	 *                the given attempt. The quiz is identified by its name.
	 */
	public void addHighscore(Attempt attempt, String name) {
		try {
			remoteInterface.addHighscore(attempt, name);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return Returns the IP address of the server.
	 */
	public String getIp() {
		return this.ip;
	}

	/**
	 * @return Returns the port of the server.
	 */
	public int getPort() {
		return this.port;
	}
}
