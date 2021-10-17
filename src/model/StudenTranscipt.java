package model;

public class StudenTranscipt {
    private Student student;
    private Math math;

    public StudenTranscipt(Student student, Math math) {
        this.student = student;
        this.math = math;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Math getMath() {
        return math;
    }

    public void setMath(Math math) {
        this.math = math;
    }

    @Override
    public String toString() {
        return "StudenTranscipt { " +
                "student = " + student +
                ", math=" + math +
                '}';
    }
}
