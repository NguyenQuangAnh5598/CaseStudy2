package manage;


import model.StudenTranscipt;
import model.Student;
import model.SubjectGeneric;
import model.Subjects;


import java.io.Serializable;
import java.util.List;

public class TeacherManage implements Serializable {
    StudentTransciptManage studentTransciptManage = StudentTransciptManage.getInstance();

    private TeacherManage() {
    }

    private static TeacherManage teacherManage;

    public static TeacherManage getInstance() {
        if (teacherManage == null) {
            teacherManage = new TeacherManage();
        }
        return teacherManage;
    }


    public StudenTranscipt checkStudentInfo(String id) {
        StudenTranscipt studentInfo = studentTransciptManage.getStudentInfo(id);
        return studentInfo;
    }

    public void addNewStudent(Student student, List<SubjectGeneric<Subjects, Integer>> subjectGenericList) {
        studentTransciptManage.addStudent(student, subjectGenericList);
    }

    public void addNewSubject(Subjects subjects, int scores, String id) {
        studentTransciptManage.addNewSubject(subjects, scores, id);
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

    public SubjectGeneric<Subjects, Integer> deletedSubjectOfStudent(String id, String subjectName) {
        SubjectGeneric<Subjects, Integer> deletedSubject = studentTransciptManage.deleteSubject(id, subjectName);
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

    public StudenTranscipt sortScoresFromBigToSmallByID(String id) {
        StudenTranscipt studenTranscipt = studentTransciptManage.sortScoresFromBigToSmallByID(id);
        return studenTranscipt;
    }

    public StudenTranscipt sortScoresFromSmallToBigByID(String id) {
        StudenTranscipt studenTranscipt = studentTransciptManage.sortScoresFromSmallToBigByID(id);
        return studenTranscipt;
    }

    public List<StudenTranscipt> sortListByNameFromUpToDown() {
        List<StudenTranscipt> newStudenyTranscriptList = StudentTransciptManage.sortListByNameFromUpToDown();
       return newStudenyTranscriptList;
    }
}
