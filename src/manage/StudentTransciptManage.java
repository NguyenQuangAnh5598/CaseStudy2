package manage;

import model.StudenTranscipt;
import model.Student;
import model.SubjectGeneric;
import model.Subjects;

import java.util.List;

public class StudentTransciptManage {
    private List<StudenTranscipt> studenTransciptList;

    public int getStudentIndex(String id) {
        int index = 0;
        for (int i = 0; i < studenTransciptList.size(); i++) {
            if (id.equals(studenTransciptList.get(i).getStudent().getId())) {
                index = i;
            }
        }
        return index;
    }

    public int getSubjectIndex(List<SubjectGeneric<Subjects, Integer>> studentSubjectList, String id) {
        int index = 0;
        for (int i = 0; i < studentSubjectList.size(); i++) {
            if (id.equals(studentSubjectList.get(i).getSubject().getSubjectName())) {
                index = i;
            }
        }
        return index;
    }


    public void addStudent(Student student, List<SubjectGeneric<Subjects, Integer>> subjectGenericList) {
        studenTransciptList.add(new StudenTranscipt(student, subjectGenericList));
    }

    public void setScores(List<SubjectGeneric<Subjects, Integer>> subjectList, String subjectName, int scores) {
        subjectList.get(getSubjectIndex(subjectList, subjectName)).setScores(scores);
    }

    public void setStudentName(String studentName, String id) {
        studenTransciptList.get(getStudentIndex(id)).getStudent().setName(studentName);
    }

    public StudenTranscipt deleteStudent(String id) {
        studenTransciptList.remove(getStudentIndex(id));
        return studenTransciptList.get(getStudentIndex(id));
    }

    public StudenTranscipt getStudentInfo(String id) {
        for (int i = 0; i < studenTransciptList.size(); i++) {
            if (id.equals(studenTransciptList.get(i).getStudent().getId())) {
                return studenTransciptList.get(i);
            }
        }
        return null;
    }

    public void addNewSubject(List<SubjectGeneric<Subjects, Integer>> subjectList, Subjects subjects, int scores) {
        subjectList.add(new SubjectGeneric<>(subjects, scores));
    }

    public SubjectGeneric<Subjects, Integer> deleteSubject(List<SubjectGeneric<Subjects, Integer>> subjectList, String subjectName) {
        subjectList.remove(getSubjectIndex(subjectList, subjectName));
        return subjectList.get(getSubjectIndex(subjectList, subjectName));
    }


}
