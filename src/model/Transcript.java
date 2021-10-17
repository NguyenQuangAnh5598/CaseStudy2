package model;

public class Transcript {
    private String idOfStudent;
    private StudenTranscipt studenTranscipt;

    public Transcript(String idOfStudent, StudenTranscipt studenTranscipt) {
        this.idOfStudent = idOfStudent;
        this.studenTranscipt = studenTranscipt;

    }

    public String getIdOfStudent() {
        return idOfStudent;
    }

    public void setIdOfStudent(String idOfStudent) {
        this.idOfStudent = idOfStudent;
    }

    public StudenTranscipt getStudenTranscipt() {
        return studenTranscipt;
    }

    public void setStudenTranscipt(StudenTranscipt studenTranscipt) {
        this.studenTranscipt = studenTranscipt;
    }

    @Override
    public String toString() {
        return "Transcript { " +
                " idOfStudent = '" + idOfStudent + '\'' +
                " " + studenTranscipt +
                " }";
    }
}
