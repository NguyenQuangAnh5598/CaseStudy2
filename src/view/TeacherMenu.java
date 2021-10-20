package view;

import manage.TeacherManage;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherMenu {
    static TeacherManage teacherManage = new TeacherManage();
    public static List<StudenTranscipt> studenTransciptList = new ArrayList<>();

    public static void menu() {
        Scanner scanner= new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("--------MENU--------");
            System.out.println("0.Exit");
            System.out.println("1.In Bảng Điểm");
            System.out.println("2.Lấy Thông tin học sinh bằng ID");
            System.out.println("3.Tạo mới Học sinh");
            System.out.println("4.Tạo thêm môn học ");
            System.out.println("5.Chỉnh sửa điểm môn học");
            System.out.println("6.Chỉnh sửa tên Học sinh");
            System.out.println("7.Xóa Học sinh");
            System.out.println("8.Xóa Môn học");
            System.out.println("9.Xem tổng điểm các môn của học sinh qua ID");
            System.out.println("10.Xem điểm Trung bình các môn của học sinh qua ID");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 :
                    printStudentTranscriptList();
                    break;
                case 2 :
                    getStudentInfo();
                    break;
                case 3 :
                    addNewStudent();
                    break;
                case 4 :
                    addNewSubject();
                    break;
                case 5 :
                    setSubjectScores();
                    break;
                case 6 :
                    setStudentName();
                    break;
                case 7 :
                    deleteStudent();
                    break;
                case 8 :
                    deleteSubjectOfStudent();
                    break;
                case 9 :
                    getSumScroresOfStudentByID();
                    break;
                case 10 :
                    getAverageScoresOfStudentByID();
                    break;
            }
        } while (choice != 0 ) ;

    }
    public static void printStudentTranscriptList() {
        for (StudenTranscipt x : studenTransciptList) {
            System.out.println(x);
        }
    }

    public static void getStudentInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID học sinh mà bạn muốn xem thông tin:");
        String id = scanner.nextLine();
        teacherManage.checkStudentInfo(id);
    }

    public static void addNewStudent() {
        Scanner scanner = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);

        System.out.println("Nhập tên học sinh muốn thêm:");
        String studentName = scanner.nextLine();
        System.out.println("Nhập ID học sinh:");
        String studentID = scan.nextLine();
        Student student = new Student(studentName, studentID);

        List<SubjectGeneric<Subjects, Integer>> subjectGenericList = new ArrayList<>();

        teacherManage.addNewStudent(student, subjectGenericList);
    }

    public static void addNewSubject() {
        Scanner scanner = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);

        System.out.println("Nhập ID học sinh muốn thêm môn học: ");
        String id = scan.nextLine();
        System.out.println("Nhập tên môn học muốn thêm: ");
        String subjectName = scanner.nextLine();
        Subjects subjects = new Subjects(subjectName);

        System.out.println("Nhập điểm :");
        int scores = scan.nextInt();

        teacherManage.addNewSubject(subjects, scores, id);
    }

    public static void setSubjectScores() {
        Scanner scanner = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);

        System.out.println("Nhập ID học sinh muốn chỉnh điểm: ");
        String id = scanner.nextLine();
        System.out.println("Nhập tên môn học muốn chỉnh điểm: ");
        String subjectName = scan.nextLine();
        System.out.println("Nhập điểm mới: ");
        int scores = scanner.nextInt();

        teacherManage.setSubjectScores(id, subjectName, scores);
    }

    public static void setStudentName() {
        Scanner scanner = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);

        System.out.println("Nhập ID học sinh muốn chỉnh tên: ");
        String id = scanner.nextLine();
        System.out.println("Nhập tên mới: ");
        String name = scan.nextLine();

        teacherManage.setStudentName(id, name);
    }

    public static void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID học sinh muốn xóa: ");
        String id = scanner.nextLine();
        StudenTranscipt deletedStudent = teacherManage.deleteStudent(id);
        System.out.println("Đã xóa bảng điểm : " + deletedStudent);
    }

    public static void deleteSubjectOfStudent() {
        Scanner scanner = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);

        System.out.println("Nhập ID học sinh muốn xóa môn học: ");
        String id = scanner.nextLine();
        System.out.println("Nhập tên môn học muốn xóa: ");
        String subject = scan.nextLine();
        SubjectGeneric<Subjects, Integer> deletedSubject = teacherManage.deletedSubjectOfStudent(id, subject);
        System.out.println("Đã xóa môn học :" + deletedSubject);
    }

    public static void getSumScroresOfStudentByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID học sinh muốn tính Tổng điểm các môn: ");
        String id = scanner.nextLine();

        int sumScores = teacherManage.getSumScroresOfStudentByID(id);
        System.out.println("Tổng điểm các môn của học sinh có mã ID: " + id + " là " + sumScores + " điểm");
    }

    public static void getAverageScoresOfStudentByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID học sinh muốn tính điểm Trung Bình các môn: ");
        String id = scanner.nextLine();

        double averageScores = teacherManage.getAverageScoresOfStudentByID(id);
        System.out.println("Điểm Trung Bình các môn học của Học sinh có mã ID: " + id + " là " + averageScores + " điểm");
    }

}
