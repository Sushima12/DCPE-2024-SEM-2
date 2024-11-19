import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Activity5_2 {
    public static void main(String[] args) {
        String s = "a.txt";
        readTextFile(s);
        //If try catch is in main(), in the readTextFile(), have to throw exception
    }
    public static void readTextFile(String a) {
        String s;
        try {
            File myFile = new File(a);
            Scanner sc = new Scanner(myFile);
            while (sc.hasNextLine()) { // loop to read entire file
                s = sc.nextLine();
                System.out.println(s);
            }
        } catch(FileNotFoundException e) {
            System.out.println("File Not Found...");

        }
    }
}


