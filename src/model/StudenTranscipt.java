package model;

public class StudenTranscipt {
    private String studentName;
    private String studentID;
    private Math math;

    public StudenTranscipt(String studentName, String studentID, Math math) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.math = math;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Math getMath() {
        return math;
    }

    public void setMath(Math math) {
        this.math = math;
    }
}
