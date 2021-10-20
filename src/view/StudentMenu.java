package view;

import manage.StudentManage;
import model.StudenTranscipt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMenu {
    public static List<StudenTranscipt> studenTransciptList = new ArrayList<>();
    static StudentManage studentManage = StudentManage.getInstance();

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("--------MENU--------");
            System.out.println("0.Exit");
            System.out.println("1.Xem thông tin của bạn ");
            System.out.println("2.Chỉnh tên");
            System.out.println("3.Xem Tổng điểm của các môn");
            System.out.println("4.Xem Điểm Trung Bình của các môn");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkInfoByID();
                    break;
                case 2:
                    setNameByID();
                    break;
                case 3:
                    getSumScroresByID();
                    break;
                case 4:
                    getAverageScoresOfStudentByID();
                    break;
            }
        } while (choice != 0);
    }

    public static void checkInfoByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID của bạn vào đây: ");
        String id = scanner.nextLine();
        studentManage.checkInfo(id);
    }

    public static void setNameByID() {
        Scanner scanner = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);

        System.out.println("Nhập ID của bạn vào đây: ");
        String id = scanner.nextLine();
        System.out.println("Nhập tên mới : ");
        String name = scan.nextLine();
        studentManage.setName(id, name);
    }

    public static void getSumScroresByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID của bạn vào đây: ");
        String id = scanner.nextLine();

        int sumScores = studentManage.getSumScroresByID(id);
        System.out.println("Tổng điểm các môn của học sinh có mã ID là " + sumScores + " điểm");
    }

    public static void getAverageScoresOfStudentByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID học sinh muốn tính điểm Trung Bình các môn: ");
        String id = scanner.nextLine();

        double averageScores = studentManage.getAverageScoresByID(id);
        System.out.println("Điểm Trung Bình các môn học của bạn là " + averageScores + " điểm");
    }
}
