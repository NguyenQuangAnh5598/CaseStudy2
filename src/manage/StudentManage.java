package manage;

import model.Transcript;

import java.util.ArrayList;
import java.util.List;

public class StudentManage {
    private static List<Transcript> transcriptList = new ArrayList<>();
    public static void checkscrore(String studentId) {
        for (int i = 0; i < transcriptList.size() ; i++) {
            if (studentId.equals(transcriptList.get(i).getIdOfStudent())) {
                System.out.println(transcriptList.get(i).getStudenTranscipt());
            }
        }

    }
}
