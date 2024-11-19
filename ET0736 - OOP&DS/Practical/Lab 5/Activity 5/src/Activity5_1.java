import java.util.InputMismatchException;
import java.util.Scanner;

public class Activity5_1 {
    public static void main(String[] args) {
        int size = 0; // need to initialise first
        Scanner sc = new Scanner(System.in);
        while(size <= 0) {
            //while loop to loop try catch
            try {

                System.out.println("Enter Array Size: ");
                size = sc.nextInt();
            } catch (InputMismatchException e) {
                //unchecked exception
                System.out.println("Invalid Number, Try Again");
            }
        }

        double []num = new double[size];
        double input;
        System.out.println("array size: " + num.length);

        int n = 0;
        while(n < num.length) {
            try {
                System.out.println("current index (n): " + n);
                System.out.println("Enter number to array: ");
                sc = new Scanner(System.in);
                input = sc.nextInt();
                num[n] = input;
                n++;
            } catch (Exception e) {
                System.out.println("Invalid Number, Try Again");
            }
        }

        System.out.println("Average of numbers in array: " + avgArry(num));

    }
    public static double avgArry(double[ ] a) {
        double sum = 0;
        double avg;

        //for loop
        for (int i = 0; i < a.length; i++) {
             sum += a[i];
        }
        /*
        //do-while loop
        int ii = 0;
        do {
            sum += a[ii];
            ii++;
        } while(ii <= a.length);
        */

        /*
        //while loop
        int iii = 0;
        while (iii <= 0) {
            sum += a[iii];
            iii++;
        }
        */

        avg = sum / a.length;
        return avg;
    }
}