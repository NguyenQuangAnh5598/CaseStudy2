package manage;

import model.StudenTranscipt;
import model.Student;
import model.SubjectGeneric;
import model.Subjects;

import java.util.List;

public class StudentTransciptManage {

    private List<StudenTranscipt> studenTransciptList;
    private List<SubjectGeneric<Subjects,Integer>> studentSubjectList;

    public int getStudentIndex(String id) {
        int index = 0;
        for (int i = 0; i < studenTransciptList.size(); i++) {
            if (id.equals(studenTransciptList.get(i).getStudent().getId())) {
                index = i;
            }
        }
        return index;
    }

//    public int getSubjectIndex(String subjectName) {
//        int index = 0;
//        for (int i = 0; i < studentSubjectList.size(); i++) {
//            if (subjectName.equals(studentSubjectList.get(i).getSubject().getSubjectName())) {
//                index = i;
//            }
//        }
//        return index;
//    }


    public void addStudent(Student student, List<SubjectGeneric<Subjects, Integer>> subjectGenericList) {
        studenTransciptList.add(new StudenTranscipt(student, subjectGenericList));
    }

//    public void setScores(String subjectName, int scores,String id) {
//        studenTransciptList.get(getStudentIndex(id)).getStudentSubjectList().get(getSubjectIndex(subjectName)).setScores(scores);
//
//    }

    public void setStudentName(String studentName, String id) {
        studenTransciptList.get(getStudentIndex(id)).getStudent().setName(studentName);
    }

    public StudenTranscipt deleteStudent(String id) {
        studenTransciptList.remove(getStudentIndex(id));
        return studenTransciptList.get(getStudentIndex(id));
    }

    public StudenTranscipt getStudentInfo(String id) {
        return studenTransciptList.get(getStudentIndex(id));
    }


    public void addNewSubject(List<SubjectGeneric<Subjects, Integer>> subjectList, Subjects subjects, int scores) {
        subjectList.add(new SubjectGeneric<>(subjects, scores));
    }

//    public SubjectGeneric<Subjects, Integer> deleteSubject(String subjectName,String id) {
//        studenTransciptList.get(getStudentIndex(id)).getStudentSubjectList().remove(getSubjectIndex(subjectName));
//        return studenTransciptList.get(getStudentIndex(id)).getStudentSubjectList().get(getSubjectIndex(subjectName));
//    }

//    public int getSumScoresByID(String id) {
//       List<SubjectGeneric<Subjects,Integer>> subjectList = studenTransciptList.get(getStudentIndex(id)).getStudentSubjectList();
//        int sum = 0;
//        for (int i = 0; i < subjectList.size(); i++) {
//            sum += subjectList.get(i).getScores();
//        }
//        return sum;
//    }
//
//    public double getAverageScoresByID(List<SubjectGeneric<Subjects, Integer>> subjectList,String id) {
//        int sum = getSumScoresByID(id);
//        double averageScores = sum / (subjectList.size());
//        return averageScores;
//    }
}
