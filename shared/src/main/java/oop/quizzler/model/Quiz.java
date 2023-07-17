package oop.quizzler.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Quiz implements Serializable {
    private String name;
    private ArrayList<Question> questions = new ArrayList<Question>();
    private ArrayList<Attempt> scores = new ArrayList<Attempt>();

    public Quiz(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setQuestion(Question question) {
        this.questions.add(question);
    }

    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

    public int getQuestionsInt(){
        return this.questions.size();
    }

    public void setAttempt(Attempt attempt) {
        this.scores.add(attempt);
        Collections.sort(scores);;
    }

    public ArrayList<Attempt> getAttempts() {
        return scores;
    }
}

