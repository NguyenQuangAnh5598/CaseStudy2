package manage;

import model.StudenTranscipt;
import model.Student;
import model.SubjectGeneric;

import java.util.ArrayList;
import java.util.List;

public class TeacherManage {
    private static List<StudenTranscipt> studenTransciptList = new ArrayList<>();

    public static List<StudenTranscipt> getStudenTransciptList() {
        return studenTransciptList;
    }

    public static void setStudenTransciptList(List<StudenTranscipt> studenTransciptList) {
        TeacherManage.studenTransciptList = studenTransciptList;
    }

    public static void checkStudentInfo(String studentId) {
        for (int i = 0; i < studenTransciptList.size(); i++) {
            if (studentId.equals(studenTransciptList.get(i).getStudent().getId())) {
                System.out.println(studenTransciptList.get(i));
            }
        }
    }

    public static void setStudent(String studentId, SubjectGeneric subjectGeneric, Student student) {
        for (int i = 0; i < studenTransciptList.size(); i++) {
            if (studentId.equals(studenTransciptList.get(i).getStudent().getId())) {
                studenTransciptList.get(i).setStudent(student);
                studenTransciptList.get(i).sets(subjectGeneric);
            }
        }
    }

}
