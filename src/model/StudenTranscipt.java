package model;

import java.io.Serializable;
import java.util.List;

public class StudenTranscipt implements Serializable {
    private Student student;
    private List<SubjectGeneric<Subjects, Integer>> studentSubjectList;
    private SubjectGeneric<Subjects,Integer> subjectGeneric;

    public StudenTranscipt(Student student, List<SubjectGeneric<Subjects, Integer>> studentSubjectList) {
        this.student = student;
        this.studentSubjectList = studentSubjectList;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<SubjectGeneric<Subjects, Integer>> getStudentSubjectList() {
        return studentSubjectList;
    }

    public void setStudentSubjectList(List<SubjectGeneric<Subjects, Integer>> studentSubjectList) {
        this.studentSubjectList = studentSubjectList;
    }

    @Override
    public String toString() {
        return "\nStudenTranscipt { " +
                "Student : " + student +
                 studentSubjectList +
                  subjectGeneric +
                " }";
    }
}
