package oop.quizzler.controller;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import oop.quizzler.model.Server;
import java.net.InetAddress;

/**
 * This class starts the server.
 */
public class StartServer {
	private static Server server;

	/**
	 * main method. Starts the server. Creates a registry and binds the Server
	 * object to it. Prints the IP and PORT of the server. If the server fails to
	 * start, it prints "Failed".
	 * 
	 * @return Returns the IP of the server.
	 */
	public static String start() {
		try {
			InetAddress IP = InetAddress.getLocalHost();
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("Quizzler", server = new Server());
			System.out.println("Server running.\nIP: " + IP.getHostAddress() + "\nPORT: " + Registry.REGISTRY_PORT);
			return IP.getHostAddress();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Stops the server. Unbinds the Server object from the registry and unexports
	 * Gives feedback in the console.
	 * 
	 */
	public static void stop() {
		try {
			Naming.unbind("Quizzler");
			UnicastRemoteObject.unexportObject(server, true);
			System.out.println("Server stopped.");
		} catch (Exception e) {
			System.out.println("Server already stopped.");
		}
	}
}
