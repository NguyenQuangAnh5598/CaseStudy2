package model;

import java.util.List;

public class StudenTranscipt {
    private Student student;
    private List<SubjectGeneric<Subjects, Integer>> studentSubjectList;

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
}
