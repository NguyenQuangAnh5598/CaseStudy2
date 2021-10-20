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

    public void setScoresInStudentTranscriptObject(String id, String subjectName, int scores) {
        SubjectGeneric setSubject = studenTransciptList.get(getStudentIndex(id)).getStudentSubjectList().get(getSubjectIndex(studenTransciptList.get(getStudentIndex(id)).getStudentSubjectList(), subjectName));
        setSubject.setScores(scores);
    }

    public int getSubjectIndex(List<SubjectGeneric<Subjects, Integer>> studentSubjectList, String subjectName) {
        int index = 0;
        for (int i = 0; i < studentSubjectList.size(); i++) {
            if (subjectName.equals(studentSubjectList.get(i).getSubject().getSubjectName())) {
                index = i;
            }
        }
        return index;
    }


    public void addStudent(Student student, List<SubjectGeneric<Subjects, Integer>> subjectGenericList) {
        studenTransciptList.add(new StudenTranscipt(student, subjectGenericList));
    }


    public void setStudentName(String id, String studentName) {
        studenTransciptList.get(getStudentIndex(id)).getStudent().setName(studentName);
    }

    public StudenTranscipt deleteStudent(String id) {
        studenTransciptList.remove(getStudentIndex(id));
        return studenTransciptList.get(getStudentIndex(id));
    }

    public StudenTranscipt getStudentInfo(String id) {
        return studenTransciptList.get(getStudentIndex(id));
    }


    public void addNewSubject(Subjects subjects, int scores,String id) {
        List<SubjectGeneric<Subjects, Integer>> studentSubjectList = studenTransciptList.get(getStudentIndex(id)).getStudentSubjectList();
        studentSubjectList.add(new SubjectGeneric<>(subjects, scores));
    }

    public SubjectGeneric<Subjects, Integer> deleteSubject(String id, String subjectName) {
        List<SubjectGeneric<Subjects, Integer>> studentSubjectList = studenTransciptList.get(getStudentIndex(id)).getStudentSubjectList();
        studentSubjectList.remove(getSubjectIndex(studenTransciptList.get(getStudentIndex(id)).getStudentSubjectList(),subjectName));
        return studentSubjectList.get(getSubjectIndex(studenTransciptList.get(getStudentIndex(id)).getStudentSubjectList(),subjectName));
    }

    public int getSumScoresByID(String id) {
       List<SubjectGeneric<Subjects,Integer>> studentSubjectList = studenTransciptList.get(getStudentIndex(id)).getStudentSubjectList();
        int sum = 0;
        for (int i = 0; i < studentSubjectList.size(); i++) {
            sum += studentSubjectList.get(i).getScores();
        }
        return sum;
    }

    public double getAverageScoresByID(String id) {
        int sum = getSumScoresByID(id);
        List<SubjectGeneric<Subjects,Integer>> studentSubjectList = studenTransciptList.get(getStudentIndex(id)).getStudentSubjectList();
        double averageScores = sum / (studentSubjectList.size());
        return averageScores;
    }
}
