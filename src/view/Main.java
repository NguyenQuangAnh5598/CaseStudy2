package view;

import manage.StudentManage;
import manage.StudentTransciptManage;
import model.StudenTranscipt;
import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public List<StudenTranscipt> studenTransciptList = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int choice=-1;
        do {
            System.out.println("--------MENU--------");
            System.out.println("1.Giáo Viên");
            System.out.println("2.Học Sinh");
            System.out.println("0.Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 :
                    TeacherMenu.menu();
                    break;
                case 2 :
                    StudentMenu.menu();
                    break;
            }
        }while (choice != 0 ) ;
    }
}
