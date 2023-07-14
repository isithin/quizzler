package oop.quizzler.controller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import oop.quizzler.model.Server;

public class StartServer {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Quizzler", new Server());
            System.out.println("Server running.");
        } catch(RemoteException e) {
            e.printStackTrace();
            System.out.println("Failed");
        }
    }
}
