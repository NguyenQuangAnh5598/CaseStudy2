package manage;

import model.StudenTranscipt;
import model.Transcript;

import java.util.ArrayList;
import java.util.List;

public class StudentManage {
    private static List<StudenTranscipt> studenTransciptList = new ArrayList<>();

    public static List<StudenTranscipt> getStudenTransciptList() {
        return studenTransciptList;
    }

    public static void setStudenTransciptList(List<StudenTranscipt> studenTransciptList) {
        StudentManage.studenTransciptList = studenTransciptList;
    }

    public static void checkScrore(String studentId) {
        for (int i = 0; i < studenTransciptList.size() ; i++) {
            if (studentId.equals(studenTransciptList.get(i).getStudent().getId())) {
                System.out.println(studenTransciptList.get(i));
            }
        }
    }
}
