package manage;

import model.StudenTranscipt;
import model.Student;
import model.SubjectGeneric;
import model.Subjects;
import storage.FileStudentTranscriptList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentTransciptManage implements Serializable {
    private static List<StudenTranscipt> studenTransciptList = new ArrayList<>();
    private FileStudentTranscriptList fileStudentTranscriptList = FileStudentTranscriptList.getInstance();

    private StudentTransciptManage(List<StudenTranscipt> studenTransciptList) {
        this.studenTransciptList = studenTransciptList;
    }

    public static List<StudenTranscipt> getStudenTransciptList() {
        return studenTransciptList;
    }

    public static void setStudenTransciptList(List<StudenTranscipt> studenTransciptList) {
        StudentTransciptManage.studenTransciptList = studenTransciptList;
    }

    private static StudentTransciptManage studentTransciptManage = new StudentTransciptManage(studenTransciptList);


    public static StudentTransciptManage getInstance() {
        if (studentTransciptManage == null) {
            studentTransciptManage = new StudentTransciptManage(studenTransciptList);
        }
        return studentTransciptManage;
    }

    public int getStudentIndexByID(String id) {
        int index = 0;
        for (int i = 0; i < studenTransciptList.size(); i++) {
            if (id.equals(studenTransciptList.get(i).getStudent().getId())) {
                index = i;
            }
        }
        return index;
    }

    public int getSubjectIndexBySubjectName(List<SubjectGeneric<Subjects, Integer>> studentSubjectList, String subjectName) {
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
        fileStudentTranscriptList.writeFile(studenTransciptList);
    }

    public void setScoresInStudentTranscriptObject(String id, String subjectName, int scores) {
        SubjectGeneric setSubject = studenTransciptList.get(getStudentIndexByID(id)).getStudentSubjectList().get(getSubjectIndexBySubjectName(studenTransciptList.get(getStudentIndexByID(id)).getStudentSubjectList(), subjectName));
        setSubject.setScores(scores);
        fileStudentTranscriptList.writeFile(studenTransciptList);
    }

    public void setStudentName(String id, String studentName) {
      Student student =  studenTransciptList.get(getStudentIndexByID(id)).getStudent();
      student.setName(studentName);
        fileStudentTranscriptList.writeFile(studenTransciptList);
    }

    public StudenTranscipt deleteStudent(String id) {
       StudenTranscipt deletedStudent = studenTransciptList.remove(getStudentIndexByID(id));
        fileStudentTranscriptList.writeFile(studenTransciptList);
        return deletedStudent;
    }

    public StudenTranscipt getStudentInfo(String id) {
        return studenTransciptList.get(getStudentIndexByID(id));
    }


    public void addNewSubject(Subjects subjects, int scores, String id) {
        List<SubjectGeneric<Subjects, Integer>> studentSubjectList = studenTransciptList.get(getStudentIndexByID(id)).getStudentSubjectList();
        studentSubjectList.add(new SubjectGeneric<>(subjects, scores));
        fileStudentTranscriptList.writeFile(studenTransciptList);
    }

    public SubjectGeneric<Subjects, Integer> deleteSubject(String id, String subjectName) {
        List<SubjectGeneric<Subjects, Integer>> studentSubjectList = studenTransciptList.get(getStudentIndexByID(id)).getStudentSubjectList();
        SubjectGeneric deletedSubject = studentSubjectList.remove(getSubjectIndexBySubjectName(studenTransciptList.get(getStudentIndexByID(id)).getStudentSubjectList(), subjectName));
        fileStudentTranscriptList.writeFile(studenTransciptList);
        return deletedSubject;
    }

    public int getSumScoresByID(String id) {
        List<SubjectGeneric<Subjects, Integer>> studentSubjectList = studenTransciptList.get(getStudentIndexByID(id)).getStudentSubjectList();
        int sum = 0;
        for (int i = 0; i < studentSubjectList.size(); i++) {
            sum += studentSubjectList.get(i).getScores();
        }
        return sum;
    }

    public double getAverageScoresByID(String id) {
        int sum = getSumScoresByID(id);
        List<SubjectGeneric<Subjects, Integer>> studentSubjectList = studenTransciptList.get(getStudentIndexByID(id)).getStudentSubjectList();
        double averageScores = sum / (studentSubjectList.size());
        return averageScores;
    }

    public StudenTranscipt sortScoresFromBigToSmallByID(String id) {
        List<SubjectGeneric<Subjects, Integer>> studentSubjectList = studenTransciptList.get(getStudentIndexByID(id)).getStudentSubjectList();
        boolean check = true;
        for (int i = 0; i < studentSubjectList.size() - 1 && check == true; i++) {
            check = false;
            for (int j = 0; j < studentSubjectList.size() - 1 - i; j++) {
                if (studentSubjectList.get(j).getScores() < studentSubjectList.get(j + 1).getScores()) {
                    SubjectGeneric temp = studentSubjectList.get(j);
                    SubjectGeneric temp1 = studentSubjectList.get(j + 1);
                    studentSubjectList.set(j, temp1);
                    studentSubjectList.set(j + 1, temp);
                    check = true;
                }
            }
        }
        fileStudentTranscriptList.writeFile(studenTransciptList);
        return studenTransciptList.get(getStudentIndexByID(id));
    }

    public StudenTranscipt sortScoresFromSmallToBigByID(String id) {
        List<SubjectGeneric<Subjects, Integer>> studentSubjectList = studenTransciptList.get(getStudentIndexByID(id)).getStudentSubjectList();
        StudenTranscipt studenTranscipt = studenTransciptList.get(getStudentIndexByID(id));
        boolean check = true;
        for (int i = 0; i < studentSubjectList.size() - 1 && check == true; i++) {
            check = false;
            for (int j = 0; j < studentSubjectList.size() - 1 - i; j++) {
                if (studentSubjectList.get(j).getScores() > studentSubjectList.get(j + 1).getScores()) {
                    SubjectGeneric temp = studentSubjectList.get(j);
                    SubjectGeneric temp1 = studentSubjectList.get(j + 1);
                    studentSubjectList.set(j, temp1);
                    studentSubjectList.set(j + 1, temp);
                    check = true;
                }
            }
        }
        fileStudentTranscriptList.writeFile(studenTransciptList);
        return studenTranscipt;
    }

}
