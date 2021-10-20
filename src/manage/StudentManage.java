package manage;

import model.StudenTranscipt;


public class StudentManage {
    StudentTransciptManage studentTransciptManage = StudentTransciptManage.getInstance();

    private StudentManage() {
    }

    private static StudentManage studentManage;

    public static StudentManage getInstance() {
        if (studentManage == null) {
            studentManage = new StudentManage();
        }
        return studentManage;
    }

    public StudenTranscipt checkInfo(String id) {
        StudenTranscipt studentInfo = studentTransciptManage.getStudentInfo(id);
        return studentInfo;
    }

    public void setName(String studentName, String id) {
        studentTransciptManage.setStudentName(studentName, id);
    }



    public int getSumScroresByID(String id) {
        int sumScores = studentTransciptManage.getSumScoresByID(id);
        return sumScores;
    }

    public double getAverageScoresByID(String id) {
        double averageScores = studentTransciptManage.getAverageScoresByID(id);
        return averageScores;
    }
}
