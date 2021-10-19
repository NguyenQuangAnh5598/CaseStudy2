package manage;

import model.StudenTranscipt;
import model.Student;
import model.SubjectGeneric;
import model.Subjects;

import java.util.List;

public class StudenTransciptManage {
    private List<StudenTranscipt> studenTransciptList;

    public int getStudentIndex(String id) {
        int index = 0;
        for (int i = 0; i < studenTransciptList.size()  ; i++) {
            if (id.equals(studenTransciptList.get(i).getStudent().getId())) {
                index = i;
            }
        }
        return index;
    }

    public int getSubjectIndex(List<SubjectGeneric<Subjects, Integer>> studentSubjectList, String id) {
        int index = 0;
        for (int i = 0; i < studentSubjectList.size()  ; i++) {
            if (id.equals(studentSubjectList.get(i).getSubject().getSubjectName())) {
                index = i;
            }
        }
        return index;
    }

    public void setScores(List<SubjectGeneric<Subjects, Integer>> studentSubjectList,String subjectName,int scores) {
        studentSubjectList.get(getSubjectIndex(studentSubjectList,subjectName)).setScores(scores);
    }
    public void addStudent(Student student,List<SubjectGeneric<Subjects,Integer>> subjectGenericList) {
        studenTransciptList.add(new StudenTranscipt(student,subjectGenericList));
    }
    public StudenTranscipt getStudentInfo(String id) {
        for (int i = 0; i < studenTransciptList.size(); i++) {
            if (id.equals(studenTransciptList.get(i).getStudent().getId())) {
            return studenTransciptList.get(i);
            }
        }
        return null;
    }
    public StudenTranscipt deleteStudent(String id) {
        studenTransciptList.remove(getStudentIndex(id));
        return studenTransciptList.get(getStudentIndex(id));
    }
    public SubjectGeneric<Subjects, Integer> deleteSubject(List<SubjectGeneric<Subjects, Integer>> studentSubjectList, String subjectName) {
        studentSubjectList.remove(getSubjectIndex(studentSubjectList,subjectName));
        return studentSubjectList.get(getSubjectIndex(studentSubjectList,subjectName));
    }


}
