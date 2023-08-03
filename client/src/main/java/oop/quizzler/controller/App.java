package oop.quizzler.controller;

/**
 * This class starts the application.
 */
public class App {
	/**
	 * main method. Starts the application by calling the main of InitQuizzler
	 * class. (qad-fix to avoid javafx error) Stops the server after the application
	 * is closed.
	 * 
	 * @param args startup arguments
	 */
	public static void main(String[] args) {
		InitQuizzler.main(args);
		StartServer.stop();
	}
}
