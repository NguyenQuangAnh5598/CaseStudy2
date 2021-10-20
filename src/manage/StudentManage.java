package manage;

import model.StudenTranscipt;
import model.SubjectGeneric;
import model.Subjects;

import java.util.List;

public class StudentManage {
    public StudenTranscipt checkInfo(String id) {
        StudenTranscipt studentInfo = studentTransciptManage.getStudentInfo(id);
        return studentInfo;
    }

    public void setName(String studentName, String id) {
        studentTransciptManage.setStudentName(studentName, id);
    }

    private StudentTransciptManage studentTransciptManage = new StudentTransciptManage();

    public int getSumScroresByID(String id) {
        int sumScores = studentTransciptManage.getSumScoresByID(id);
        return sumScores;
    }

    public double getAverageScoresByID(List<SubjectGeneric<Subjects, Integer>> subjectList, String id) {
        double averageScores = studentTransciptManage.getAverageScoresByID(subjectList, id);
        return averageScores;
    }
}
