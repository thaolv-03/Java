package As2;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private static int index = 1;
    private int ID;
    private String name;
    private int semester;
    private String course;

    public Student() {
    }

    public Student(int ID, String name, int semester, String course) {
        super();
        this.ID = ID;
        this.name = name;
        this.semester = semester;
        this.course = course;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        this.ID = index++;
        System.out.print("Enter name: ");
        this.name = sc.nextLine();
        System.out.print("Enter semester: ");
        this.semester = sc.nextInt();
        System.out.print("Enter course: ");
        sc.nextLine();
        this.course = sc.nextLine();
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        Student.index = index;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student [" +
                " ID = " + ID +
                ", name = '" + name + '\'' +
                ", semester = " + semester +
                ", course = '" + course + '\'' +
                ']';
    }
}
