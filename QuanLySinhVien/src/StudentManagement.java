package As2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManagement extends Student {

    public static void main(String[] args) {
        StudentManagement sv = new StudentManagement();
        Scanner sc = new Scanner(System.in);
        boolean Menu = true;
        int choice = 0;
        String temp;
        while (Menu) {
            menu();
            temp = sc.nextLine();
            try {
                choice = Integer.parseInt(temp);
            } catch (Exception e) {
                System.out.println("Wrong option!");
                continue;
            }
            switch (choice) {
                case 1:
                    sv.AddStudent();
                    break;
                case 2:
                    sv.Find_Sort();
                    break;
                case 3:
                    sv.Update_Delete();
                    break;
                case 4:
                    sv.Report();
                    break;
                case 5:
                    Menu = false;
                    break;
                default:
                    System.err.println("Invalid! please choose action in below menu:");
                    break;
            }
        }
        System.err.print("Finish!");
    }
    ArrayList<StudentManagement> ArraylistSt = new ArrayList<StudentManagement>();

    public void AddStudent() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3;i++){
            StudentManagement sv = new StudentManagement();
            System.out.println("Please input information for creating student:");
            sv.input();
            ArraylistSt.add(sv);
        }
        boolean add = true;
        while (add) {
            System.out.println("Do you want to continue (Y/N)?");
            String choose = sc.nextLine();
            if (choose.equalsIgnoreCase("y")) {
                StudentManagement sv = new StudentManagement();
                System.out.println("Please input information for creating student:");
                sv.input();
                ArraylistSt.add(sv);
            } else if (choose.equalsIgnoreCase("n")) {
                add = false;
            } else {
                System.err.println("Please choose Y/N!");
            }
        }
        System.err.println("List of students added: ");
        show();
    }

    public void Find_Sort() {
        boolean isExisted = false;
        int size = ArraylistSt.size();
        Collections.sort(ArraylistSt, new Comparator<Student>() {
            @Override
            public int compare(Student sv1, Student sv2) {
                return (sv1.getName().compareTo(sv2.getName()));
            }
        });

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student name or a part of student name: ");
        String name = sc.nextLine();
        for (int i = 0; i < size; i++) {
            if (ArraylistSt.get(i).getName().contains(name)) {
                isExisted = true;
                System.out.println(ArraylistSt.get(i));
            }
        }
        if (!isExisted) {
            System.err.println("Student name does not exist!");
        }
    }
    private String inputName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        return sc.nextLine();
    }

    private int inputSemester() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Semester: ");
        return sc.nextInt();
    }

    private String inputCourseName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter CourseName: ");
        return sc.nextLine();
    }

    public void Update_Delete() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(sc.nextLine());
            StudentManagement sv = null;
            int size = ArraylistSt.size();
            int i;
            for (i = 0; i < size; i++) {
                if (ArraylistSt.get(i).getID() == id) {
                    sv = ArraylistSt.get(i);
                    break;
                }
            }

            if (sv != null) {
                System.out.println("Do you want to update (U) or delete (D) student");
                String choose = sc.nextLine();
                while (true) {
                    if (choose.equalsIgnoreCase("u")) {
                        ArraylistSt.get(i).setName(inputName());
                        ArraylistSt.get(i).setSemester(inputSemester());
                        ArraylistSt.get(i).setCourse(inputCourseName());
                        break;
                    } else if (choose.equalsIgnoreCase("d")) {
                        ArraylistSt.remove(sv);
                        break;
                    } else {
                        System.err.println("Please choose U/D!");
                        choose = sc.nextLine();
                    }
                }
            } else {
                System.err.println("Student code does not exist!");
            }
        } catch (Exception e) {
            System.err.println("Enter ID as number!");
        }
    }

    public void Report() {

        ArrayList<StudentManagement> reportst = new ArrayList<StudentManagement>();
        reportst = (ArrayList<StudentManagement>) ArraylistSt.clone();

        for (int i = 0; i < reportst.size(); i++) {
            int count = 1;
            String name = reportst.get(i).getName();
            String courseName = reportst.get(i).getCourse();

            for (int j = i + 1; j < reportst.size(); j++) {
                if (name.equalsIgnoreCase(reportst.get(j).getName())
                        && courseName.equalsIgnoreCase(reportst.get(j).getCourse())) {
                    count++;
                    reportst.remove(j);
                }
            }

            System.out.format("%20s | ", reportst.get(i).getName());
            System.out.format("%10s | ", reportst.get(i).getCourse());
            System.out.format("%10s | ", count);
            System.out.println();
        }

        if (ArraylistSt.size() == 0) {
            System.err.println("List without student!");
        }
        reportst.removeAll(reportst);
    }
    public static void menu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit.");
        System.out.println("-----------------------------");
        System.out.print("Please choose: ");
    }

    public void show() {
        for (Student student : ArraylistSt) {
            System.out.format("%5d | ", student.getID());
            System.out.format("%15s | ", student.getName());
            System.out.format("%5s | ", student.getSemester());
            System.out.format("%10s | ", student.getCourse());
            System.out.println();
        }
    }

}
