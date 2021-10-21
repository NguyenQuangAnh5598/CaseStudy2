package view;
import manage.StudentTransciptManage;
import storage.FileStudentTranscriptList;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Main implements Serializable {

    public static void main(String[] args) {
        FileStudentTranscriptList fileStudentTranscriptList = FileStudentTranscriptList.getInstance();
        try {
            StudentTransciptManage.setStudenTransciptList(fileStudentTranscriptList.readFile());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("--------MENU--------");
            System.out.println("1.Giáo Viên");
            System.out.println("2.Học Sinh");
            System.out.println("0.Exit");
            System.out.println("Bạn chọn:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    TeacherMenu.menu();
                    break;
                case 2:
                    StudentMenu.menu();
                    break;
            }
        } while (choice != 0);
    }
}
