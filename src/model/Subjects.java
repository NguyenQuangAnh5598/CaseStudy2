package model;

import java.io.Serializable;

public class Subjects implements Serializable {
    private String subjectName;


    public Subjects(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return " SubjectName = '" + subjectName + '\'';
    }
}
