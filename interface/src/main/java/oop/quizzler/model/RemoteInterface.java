package oop.quizzler.model;

import java.rmi.Remote;
import java.rmi.RemoteException;

import oop.quizzler.model.Attempt;
import oop.quizzler.model.Quiz;

public interface RemoteInterface extends Remote{

    public String getItem() throws RemoteException;
    
    public boolean addQuiz(Quiz quiz) throws RemoteException;

    public boolean deleteQuiz(String name) throws RemoteException;

    public Quiz getQuiz(String name) throws RemoteException;

    public String[] getQuizzesString() throws RemoteException;

    public void addHighscore(Attempt attempt, String name) throws RemoteException;
    
}
