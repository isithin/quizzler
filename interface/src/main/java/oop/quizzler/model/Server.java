package oop.quizzler.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class Server extends UnicastRemoteObject implements RemoteInterface {
    private ArrayList<Quiz> quizzes = new ArrayList<Quiz>();

    public Server() throws RemoteException {
        super();
        File data = new File("Data.txt");
        if (data.exists()) {
            try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(data))) {
                quizzes = (ArrayList<Quiz>) input.readObject();
                System.out.println("Loading Quizzes");
                input.close();
            } catch(IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean addQuiz(Quiz newquiz) {
        if (newquiz != null) {
            quizzes.add(newquiz);
            flush();
            System.out.println("Quiz added");
            return true;
        }
        return false;
        
    }

    public Quiz getQuiz(String name) {
        System.out.println(quizzes);
        for (Quiz quiz: quizzes) {
            if (quiz.getName().equals(name)) {
                return quiz;
            }
        }
        return null;
    }

    public boolean deleteQuiz(String name) {
        for (Quiz quiz: quizzes) {
            if (quiz.getName().equals(name)) {
                quizzes.remove(quiz);
                return true;
            }
        }
        return false;
    }

    public String[] getQuizzesString() {
        int pos = 0;
        String[] quizlist = new String[quizzes.size()];
            for (Quiz quiz: quizzes) {
                quizlist[pos] = new String(quiz.getName());
                pos++;
            }
        return quizlist;
    }

    public void addHighscore(Attempt score, String name) {
        for (Quiz quiz: quizzes) {
            if (quiz.getName().equals(name)) {
                quiz.setAttempt(score);
                flush();
            }
        }
    }

    public String getItem() {
        return "Raff_erst_mal_das_Speichern";
    }

    private void flush() {
        File data = new File("Data.txt");
        if (data.exists()) {
            data.delete();
        }
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(data))) {
            output.writeObject(quizzes);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    
}

