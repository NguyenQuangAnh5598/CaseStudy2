package manage;


import model.StudenTranscipt;
import model.Student;
import model.SubjectGeneric;
import model.Subjects;

import java.util.List;

public class TeacherManage {
    private StudentTransciptManage studentTransciptManage = new StudentTransciptManage();

    public StudenTranscipt checkStudentInfo(String id) {
        StudenTranscipt studentInfo = studentTransciptManage.getStudentInfo(id);
        return studentInfo;
    }

    public void addNewStudent(Student student, List<SubjectGeneric<Subjects, Integer>> subjectGenericList) {
        studentTransciptManage.addStudent(student, subjectGenericList);
    }

    public void addNewSubject(Subjects subjects, int scores,String id) {
        studentTransciptManage.addNewSubject(subjects, scores,id);
    }

    public void setSubjectScores(String id, String subjectName, int scores) {
        studentTransciptManage.setScoresInStudentTranscriptObject(id, subjectName, scores);
    }

    public void setStudentName(String id, String studentName) {
        studentTransciptManage.setStudentName(id, studentName);
    }

    public StudenTranscipt deleteStudent(String id) {
        StudenTranscipt deletedStudent = studentTransciptManage.deleteStudent(id);
        return deletedStudent;
    }

    public SubjectGeneric<Subjects, Integer> deletedSubjectOfStudent( String id,String subjectName) {
        SubjectGeneric<Subjects, Integer> deletedSubject = studentTransciptManage.deleteSubject(id,subjectName);
        return deletedSubject;
    }

    public int getSumScroresOfStudentByID(String id) {
        int sumScores = studentTransciptManage.getSumScoresByID(id);
        return sumScores;
    }





















    public double getAverageScoresOfStudentByID(String id) {
        double averageScores = studentTransciptManage.getAverageScoresByID(id);
        return averageScores;
    }

}
