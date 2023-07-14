package oop.quizzler.model;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Connection {

    private RemoteInterface remoteInterface;

    public Connection() {
        this.remoteInterface = getConnection();
    
    }

    public RemoteInterface getConnection() {
        try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1099);
			remoteInterface = (RemoteInterface) reg.lookup("Quizzler");
			System.out.println("Connected.");          
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("Connection failed.");
		} catch (NotBoundException e) {
			e.printStackTrace();
			System.out.println("Connection failed.");
		} 
        return remoteInterface;
    }

    public boolean addQuizToServer(Quiz newquiz) {
        try {
            return remoteInterface.addQuiz(newquiz);
        } catch(RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteQuizFromServer(String name) {
        try {
            return remoteInterface.deleteQuiz(name);
        } catch(RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Quiz getQuizFromServer(String name) {
        try {
            return remoteInterface.getQuiz(name);
        } catch(RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String[] getAllQuizNamesFromServer() {
        try {
            return remoteInterface.getQuizzesString();
        } catch(RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addHighscore(Attempt attempt, String name) {
        try {
            remoteInterface.addHighscore(attempt, name);
        } catch(RemoteException e) {
            e.printStackTrace();
        }
    }

    public String getItem() {
        try {
            return remoteInterface.getItem();
        } catch(RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }



}
