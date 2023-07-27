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
     * constructor that sets the name of the quiz
     */
    public Quiz(String name) {
        this.name = name;
    }

    /**
     * @return
     * returns the name of the quiz
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param question
     * adds a question to the array list of questions
     */
    public void setQuestion(Question question) {
        this.questions.add(question);
    }

    /**
     * @return
     * returns the questions of the quiz in the form of an array list of questions
     */
    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

    /**
     * @return
     * returns the number of questions in the quiz
     */
    public int getQuestionsInt(){
        return this.questions.size();
    }

    /**
     * @param attempt
     * adds an attempt to the scores of the quiz
     * sorts the scores from high to low using Collections
     */
    public void setAttempt(Attempt attempt) {
        this.scores.add(attempt);
        Collections.sort(scores);
    }

    /**
     * @return
     * returns the attempts of the quiz in the form of an array list of attempts
     */
    public ArrayList<Attempt> getAttempts() {
        return scores;
    }
}

