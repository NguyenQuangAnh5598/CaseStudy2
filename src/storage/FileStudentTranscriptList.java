package storage;

import model.StudenTranscipt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStudentTranscriptList {
    private static FileStudentTranscriptList fileStudentTranscriptList;

    public FileStudentTranscriptList() {
    }

    public static FileStudentTranscriptList getInstance() {
        if (fileStudentTranscriptList == null) {
            fileStudentTranscriptList = new FileStudentTranscriptList();
        }
        return fileStudentTranscriptList;
    }

    public List<StudenTranscipt> readFile() throws IOException, ClassNotFoundException {
        File file = new File("StudentTranscriptList.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() > 0) {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            List<StudenTranscipt> studenTransciptList = (List<StudenTranscipt>) object;
            objectInputStream.close();
            fileInputStream.close();
            return studenTransciptList;
        } else return new ArrayList<>();
    }

    public void writeFile(List<StudenTranscipt> studenTransciptList) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("StudentTranscriptList.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(studenTransciptList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
