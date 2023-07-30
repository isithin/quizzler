package oop.quizzler.controller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.net.InetAddress;
import java.net.UnknownHostException;
import oop.quizzler.model.Server;

/**
 * This class starts the server.
 */
public class StartServer {
	/**
	 * main method. Starts the server. Creates a registry and binds the Server
	 * object to it. Prints the IP and PORT of the server. If the server fails to
	 * start, it prints "Failed".
	 * 
	 * @param args startup arguments
	 */
	public static void main(String[] args) {
		try {
			InetAddress IP = InetAddress.getLocalHost();
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("Quizzler", new Server());
			System.out.println("Server running.\nIP: " + IP.getHostAddress() + "\nPORT: " + Registry.REGISTRY_PORT);
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("Failed");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
