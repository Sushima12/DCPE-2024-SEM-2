public class Activty7_2 {
    public static void main(String[] args) {
        System.out.println(FibNumFrom(34,55,5));
    }

    public static int FibNumFrom (int first, int second, int n) {
        //
        if (n == 0) {
            return first;
        } else if (n == 1) {
            return second;
        } else {
            //General Case:
            return FibNumFrom(first, second,n-1) + FibNumFrom(first, second,n-2);
        }
    }
}
