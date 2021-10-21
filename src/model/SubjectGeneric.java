package model;

import java.io.Serializable;

public class SubjectGeneric<U,N> implements Serializable {
    private U subject;
    private N scores;

    public SubjectGeneric(U subject, N scores) {
        this.subject = subject;
        this.scores = scores;
    }

    public U getSubject() {
        return subject;
    }

    public void setSubject(U subject) {
        this.subject = subject;
    }

    public N getScores() {
        return scores;
    }

    public void setScores(N scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "{ Subject = " + subject +
                " , Scores = " + scores +
                " }";
    }
}
