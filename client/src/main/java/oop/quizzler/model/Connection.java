package oop.quizzler.model;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Connection {

    private RemoteInterface remoteInterface;
    private String ip;
    private int port;

    public Connection(String ip, int port) throws RemoteException {
        this.ip = ip;
        this.port = port;
        this.remoteInterface = getConnection();
    
    }

    public RemoteInterface getConnection() {
        try {
			Registry reg = LocateRegistry.getRegistry(ip, port);
			remoteInterface = (RemoteInterface) reg.lookup("Quizzler");
			System.out.println("Connected.");          
		} catch (RemoteException e) {
			e.printStackTrace();
            //eigentlich überflüssig
			System.out.println("Connection failed.");
		} catch (NotBoundException e) {
			e.printStackTrace();
            //eigentlich überflüssig
			System.out.println("Connection failed.");
		} 
        return remoteInterface;
    }

    public RemoteInterface getRemoteInterface() {
        return this.remoteInterface;
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
    
    public String getIp() {
        return this.ip;
    }

    public int getPort() {
        return this.port;
    }           

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(int port) {
        this.port = port;
    }



}
