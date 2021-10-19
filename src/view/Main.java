package view;

import model.StudenTranscipt;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<StudenTranscipt> studenTransciptList = new ArrayList<>();

    public void printStudentScoresList() {
        for (StudenTranscipt x : studenTransciptList) {
            System.out.println(x);
        }
    }
}
