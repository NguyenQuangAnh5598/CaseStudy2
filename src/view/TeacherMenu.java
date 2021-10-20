package view;

import manage.TeacherManage;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherMenu {
    TeacherManage teacherManage = new TeacherManage();
    public List<StudenTranscipt> studenTransciptList = new ArrayList<>();

    public void printStudentTranscriptList() {
        for (StudenTranscipt x : studenTransciptList) {
            System.out.println(x);
        }
    }

    public void getStudentInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID học sinh mà bạn muốn xem thông tin:");
        String id = scanner.nextLine();
        teacherManage.checkStudentInfo(id);
    }

    public void addNewStudent() {
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

    public void addNewSubject() {
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

    public void setSubjectScores() {
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

    public void setStudentName() {
        Scanner scanner = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);

        System.out.println("Nhập ID học sinh muốn chỉnh tên: ");
        String id = scanner.nextLine();
        System.out.println("Nhập tên mới: ");
        String name = scan.nextLine();

        teacherManage.setStudentName(id, name);
    }

    public void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID học sinh muốn xóa: ");
        String id = scanner.nextLine();
        StudenTranscipt deletedStudent = teacherManage.deleteStudent(id);
        System.out.println("Đã xóa bảng điểm : " + deletedStudent);
    }

    public void deleteSubjectOfStudent() {
        Scanner scanner = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);

        System.out.println("Nhập ID học sinh muốn xóa môn học: ");
        String id = scanner.nextLine();
        System.out.println("Nhập tên môn học muốn xóa: ");
        String subject = scan.nextLine();
        SubjectGeneric<Subjects, Integer> deletedSubject = teacherManage.deletedSubjectOfStudent(id, subject);
        System.out.println("Đã xóa môn học :" + deletedSubject);
    }

    public void getSumScroresOfStudentByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID học sinh muốn tính Tổng điểm các môn: ");
        String id = scanner.nextLine();

        int sumScores = teacherManage.getSumScroresOfStudentByID(id);
        System.out.println("Tổng điểm các môn của học sinh có mã ID: " + id + " là " + sumScores + " điểm");
    }

    public void getAverageScoresOfStudentByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID học sinh muốn tính điểm Trung Bình các môn: ");
        String id = scanner.nextLine();

        double averageScores = teacherManage.getAverageScoresOfStudentByID(id);
        System.out.println("Điểm Trung Bình các môn học của Học sinh có mã ID: " + id + " là " + averageScores + " điểm");
    }

}
