import java.lang.Math;
public class Activity7_3{
    public static void main(String[] args) {
        int n = 1435;
        //Method 1:
        System.out.println("\nMethod 1: "
                + method_one(n));

        //Method 2:
        int sr = (int) Math.sqrt(n);
        System.out.println("\nMethod 2: " + method_two(n, sr, 2));
    }

    //Method 1
    public static String method_one(int num) {
        int square_root = (int) Math.sqrt(num);
        String output;
        if (num == 1) {
            output = "\n" + num + " is not a prime number";;
            return output;
        }
        for (int x = 2; x < square_root; x++) {
            if (num%x ==  0) {
                //it is not a prime if it is divisible by other numbers
                output = "\n" + num + " is not a prime number";;
                return output;
            }
        }
        output = "\n" + num + " is a prime number";
        return output;
    }

    //Method 2
    public static String method_two(int num, int sr, int x){
        String output;
        if (num == 1) {
            output = "\n" + num + " is not a prime number";;
            return output;
        }
        if (x < sr) {
            if (num % x == 0) {
                //not a prime number
                output = "\n" + num + " is not a prime number";;
                return output;
            } else if (num % x != 0) {
                //general case
                return method_two(num, sr, x + 1);
            }
        }
        output = "\n" + num + " is a prime number";
        return output;
    }
}