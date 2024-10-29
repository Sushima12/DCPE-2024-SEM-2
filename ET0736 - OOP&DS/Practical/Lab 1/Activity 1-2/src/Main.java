import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Activity 1-2
        //Grading System for Marks
        int marks;
        int option;

        Scanner sc = new Scanner(System.in);
        System.out.println("1. While Loop");
        System.out.println("2. Do-While Loop");
        System.out.println("Please Enter Version (1 or 2): ");
        option = sc.nextInt();
        System.out.println("Please Enter Marks: ");
        marks = sc.nextInt();
        if (option == 1) {
            //While Loop
            while (marks != -1) {
                System.out.println("Invalid Marks, Please re-enter Marks (-1 to Terminate): ");
                marks = sc.nextInt();
                if (0 <= marks & marks <= 100) {
                    break;
                }
            }
        } else if (option == 2) {
            //Do While Loop
            do {
                System.out.println("Invalid Marks, Please re-enter Marks (-1 to Terminate): ");
                marks = sc.nextInt();
                if (0 <= marks & marks <= 100) {
                    break;
                }
            } while (marks !=-1);
        }
        
        System.out.println("Processing...");
        if (0 <= marks & marks <= 49) {
            System.out.println("Grade: F");
        } else if (50 <= marks & marks <= 59) {
            System.out.println("Grade: D");
        } else if (60 <= marks & marks <= 69) {
            System.out.println("Grade: C");
        } else if (70 <= marks & marks <= 79) {
            System.out.println("Grade: B");
        } else if (80 <= marks & marks <= 100) {
            System.out.println("Grade: A");
        }

    }
}