package model;

public class Transcript {
    private String idOfStudent;
    private Math math;

    public Transcript(String idOfStudent, Math math) {
        this.idOfStudent = idOfStudent;
        this.math = math;
    }

    public String getIdOfStudent() {
        return idOfStudent;
    }

    public void setIdOfStudent(String idOfStudent) {
        this.idOfStudent = idOfStudent;
    }

    public Math getMath() {
        return math;
    }

    public void setMath(Math math) {
        this.math = math;
    }

    @Override
    public String toString() {
        return "Transcript { " +
                " idOfStudent = '" + idOfStudent + '\'' +
                " , math = " + math +
                " }";
    }
}
