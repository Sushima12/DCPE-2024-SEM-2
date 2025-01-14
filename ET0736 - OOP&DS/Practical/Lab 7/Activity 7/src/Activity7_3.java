import java.lang.Math;
public class Activity7_3{
    public static void main(String[] args) {
        System.out.println(method_one(1200000));
    }

    //Method 1
    public static String method_one(int num) {
        int square_root = (int) Math.sqrt(num);
        String output;
        for (int x = 2; x < square_root; x++) {
            if (num%x ==  0) {
                //it is not a prime if it is divisible by other numbers
                output = "\n" + num + " is not a prime number";;
                return output;
                
            } else if (num%x !=0)  {
                continue;
            } 
        }
        output = "\n" + num + " is a prime number";
        return output;
    }
}