import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Activity 1-4
        //Scanner
        String name[] = new String[3];
        int age[] = new int[3];
        String school[] = new String[3];
        int i=1;
        Scanner sc;
        do {
             sc = new Scanner(System.in);
            //Read Student's Name
            System.out.println("Enter Name " + i + ": ");
            name[i-1] = sc.nextLine();

            //Read Student's Age
            System.out.println("Enter Age " + i + ": ");
            age[i-1] = sc.nextInt();

            //Read Student's School
            System.out.println("Enter School " + i + ": ");
            // run again(java behaviour....) i cant explain
            
            sc = new Scanner(System.in);
            school[i-1] = sc.nextLine();
            i++;
        } while (i<=3);

        // display students’ info
        for (int x = 0; x < 3; x++) {
            System.out.println("Student " + x + ": " + name[x] + ", " + age[x] + ", " + school[x]);
        }

    }
}