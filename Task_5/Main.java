package Task_5;

import java.util.*;
import java.io.*;

class Student {
    int rollNo;
    String name;
    String grade;

    Student(int rollNo, String name, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.grade = grade;
    }

    public String toString() {
        return rollNo + "," + name + "," + grade;
    }

    void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
        System.out.println("------------------------");
    }
}

class StudentManagementSystem {

    ArrayList<Student> students = new ArrayList<>();
    final String FILE_NAME = "students.txt";

    // Load students from file
    void loadFromFile() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists())
                return;

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");

                students.add(new Student(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2]));
            }

            sc.close();
        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
    }

    // Save students to file
    void saveToFile() {
        try {
            PrintWriter pw = new PrintWriter(FILE_NAME);

            for (Student s : students) {
                pw.println(s.toString());
            }

            pw.close();
        } catch (Exception e) {
            System.out.println("Error saving file.");
        }
    }

    void addStudent(Student s) {
        students.add(s);
        saveToFile();
        System.out.println("Student Added Successfully.");
    }

    void removeStudent(int rollNo) {
        for (Student s : students) {
            if (s.rollNo == rollNo) {
                students.remove(s);
                saveToFile();
                System.out.println("Student Removed.");
                return;
            }
        }
        System.out.println("Student Not Found.");
    }

    void searchStudent(int rollNo) {
        for (Student s : students) {
            if (s.rollNo == rollNo) {
                s.display();
                return;
            }
        }
        System.out.println("Student Not Found.");
    }

    void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No Students Available.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    void editStudent(int rollNo, Scanner sc) {

        for (Student s : students) {

            if (s.rollNo == rollNo) {

                System.out.print("Enter New Name: ");
                String newName = sc.nextLine();

                System.out.print("Enter New Grade: ");
                String newGrade = sc.nextLine();

                if (newName.isEmpty() || newGrade.isEmpty()) {
                    System.out.println("Name or Grade cannot be empty.");
                    return;
                }

                s.name = newName;
                s.grade = newGrade;

                saveToFile();

                System.out.println("Student Updated.");
                return;
            }
        }

        System.out.println("Student Not Found.");
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.loadFromFile();

        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    if (roll <= 0) {
                        System.out.println("Invalid Roll Number.");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();

                    sms.addStudent(new Student(roll, name, grade));
                    break;

                case 2:
                    System.out.print("Enter Roll Number to Edit: ");
                    int editRoll = sc.nextInt();
                    sc.nextLine();

                    sms.editStudent(editRoll, sc);
                    break;

                case 3:
                    System.out.print("Enter Roll Number to Remove: ");
                    sms.removeStudent(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter Roll Number to Search: ");
                    sms.searchStudent(sc.nextInt());
                    break;

                case 5:
                    sms.displayAllStudents();
                    break;

                case 6:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 6);

        sc.close();
    }
}
