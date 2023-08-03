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
	 * Establishes a connection to the server on call and sets the remoteInterface
	 * Object.
	 * 
	 * @param ip   ip address of the server
	 * @param port port of the server
	 */
	public Connection(String ip, int port) {
		this.ip = ip;
		this.port = port;
		this.remoteInterface = getConnection();
	}

	/**
	 * Establishes a connection to the server and returns the remoteInterface
	 * Object.
	 * 
	 * @return Returns the remoteInterface Object.
	 */
	public RemoteInterface getConnection() {
		try {
			Registry reg = LocateRegistry.getRegistry(ip, port);
			remoteInterface = (RemoteInterface) reg.lookup("Quizzler");
			// for debugging
			System.out.println("Connected to " + ip);
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
	 * Adds a given new quiz to the server. Uses the remoteInterface Object
	 * 
	 * @param newquiz The quiz to be added to the server.
	 * @return Returns true if the quiz was added successfully.
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
	 * Deletes a quiz from the server. The quiz is identified by its name. Uses the
	 * remoteInterface Object.
	 * 
	 * @param name The name of the quiz to be deleted.
	 * @return Returns true if the quiz was deleted successfully.
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
	 * Returns a quiz from the server. The quiz is identified by its name. Uses the
	 * remoteInterface Object.
	 * 
	 * @param name The name of the quiz to be returned.
	 * @return Returns the quiz with the given name.
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
	 * Adds a highscore to the server. The highscore is located in the given
	 * attempt. The quiz is identified by its name.
	 * 
	 * @param attempt The attempt that contains the highscore.
	 * @param name    The name of the quiz that the highscore is added to.
	 * 
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
