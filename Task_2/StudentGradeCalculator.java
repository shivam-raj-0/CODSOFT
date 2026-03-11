package Task_2;
import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        int total = 0;

        for(int i = 1; i <= subjects; i++) {
            System.out.print("Enter marks for subject " + i + ": ");
            int marks = sc.nextInt();
            total += marks;
        }

        double average = total / (double) subjects;

        char grade;

        if(average >= 90)
            grade = 'A';
        else if(average >= 75)
            grade = 'B';
        else if(average >= 60)
            grade = 'C';
        else if(average >= 50)
            grade = 'D';
        else
            grade = 'F';

        System.out.println("Total Marks = " + total);
        System.out.println("Average Percentage = " + average);
        System.out.println("Grade = " + grade);

        sc.close();
    }
}
