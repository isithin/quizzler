package oop.quizzler.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Class that represents a quiz.
 */
public class Quiz implements Serializable {
    private String name;
    private ArrayList<Question> questions = new ArrayList<Question>();
    private ArrayList<Attempt> scores = new ArrayList<Attempt>();

    /**
     * @param name
     */
    public Quiz(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param question
     */
    public void setQuestion(Question question) {
        this.questions.add(question);
    }

    /**
     * @return
     */
    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

    /**
     * @return
     */
    public int getQuestionsInt(){
        return this.questions.size();
    }

    /**
     * @param attempt
     */
    public void setAttempt(Attempt attempt) {
        this.scores.add(attempt);
        Collections.sort(scores);
    }

    /**
     * @return
     */
    public ArrayList<Attempt> getAttempts() {
        return scores;
    }
}

