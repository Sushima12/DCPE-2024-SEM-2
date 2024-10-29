import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Activity 1-3
        //Sum and Average  of Integer Series
        float sum;
        float avg;
        float input_num;
        float counter;
        Scanner sc = new Scanner(System.in);
        System.out.println("Sum and Average of numbers");
        System.out.println("Enter a number:");
        input_num = sc.nextInt();
        sum = input_num;
        counter = 1;
        while (input_num != 0) {
            System.out.println("Enter another number (0 to Exit Loop):");
            input_num = sc.nextInt();
            sum = input_num + sum;
            counter++;
        }
        System.out.println("Sum: " + sum);
        avg = sum / counter;
        System.out.println("Average: " + avg);
    }
}