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

    public void setSubjectScores(String subjectName, int scores,String id) {
        studentTransciptManage.setScores(subjectName,scores,id);
    }



}
