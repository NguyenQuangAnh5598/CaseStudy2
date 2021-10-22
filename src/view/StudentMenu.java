package view;

import manage.StudentManage;
import model.StudenTranscipt;

import java.io.Serializable;

import java.util.Scanner;

public class StudentMenu implements Serializable {
    static StudentManage studentManage = StudentManage.getInstance();

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        try {
            int choice;
            do {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~STUDENT-MENU~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("0.Exit");
                System.out.println("1.Xem thông tin của bạn ");
                System.out.println("2.Chỉnh tên");
                System.out.println("3.Xem Tổng điểm của các môn");
                System.out.println("4.Xem Điểm Trung Bình của các môn");
                System.out.println("5.Sắp xếp điểm từ cao xuống thấp");
                System.out.println("6.Sắp xếp điểm từ thấp lên cao");
                System.out.println("Your Choine is : ");

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
                    case 5 :
                        sortScoresFromSmallToBigByStudentID();
                        break;
                    case 6 :
                        sortScoresFromSmallToBigByStudentID();
                        break;
                }
            } while (choice != 0);
        } catch (Exception e) {
            System.out.println("Nhập sai rồi !!");
        }
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

    public static void sortScoresFromBigToSmallByStudentID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID học sinh muốn sắp xếp lại bảng điểm");
        String id = scanner.nextLine();

        StudenTranscipt studenTranscipt = studentManage.sortScoresFromBigToSmallByID(id);
        System.out.println(studenTranscipt);
    }

    public static void sortScoresFromSmallToBigByStudentID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID học sinh muốn sắp xếp lại bảng điểm");
        String id = scanner.nextLine();

        StudenTranscipt studenTranscipt = studentManage.sortScoresFromSmallToBigByID(id);
        System.out.println(studenTranscipt);
    }
}
