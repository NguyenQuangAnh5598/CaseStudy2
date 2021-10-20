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

    public void addNewSubject(List<SubjectGeneric<Subjects, Integer>> subjectList, Subjects subjects, int scores) {
        studentTransciptManage.addNewSubject(subjectList, subjects, scores);
    }

    public void setSubjectScores(String id, String subjectName, int scores) {
        studentTransciptManage.setScoresInStudentTranscriptObject(id, subjectName, scores);
    }

    public void setStudentName(String studentName, String id) {
        studentTransciptManage.setStudentName(studentName, id);
    }

    public StudenTranscipt deleteStudent(String id) {
        StudenTranscipt deletedStudent = studentTransciptManage.deleteStudent(id);
        return deletedStudent;
    }

    public SubjectGeneric<Subjects, Integer> deletedSubjectOfStudent(String subjectName, String id) {
        SubjectGeneric<Subjects, Integer> deletedSubject = studentTransciptManage.deleteSubject(subjectName, id);
        return deletedSubject;
    }

    public int getSumScroresOfStudentByID(String id) {
        int sumScores = studentTransciptManage.getSumScoresByID(id);
        return sumScores;
    }

    public double getAverageScoresOfStudentByID(List<SubjectGeneric<Subjects, Integer>> subjectList, String id) {
        double averageScores = studentTransciptManage.getAverageScoresByID(subjectList, id);
        return averageScores;
    }

}
