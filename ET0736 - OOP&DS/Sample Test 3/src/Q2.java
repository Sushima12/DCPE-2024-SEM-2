public class Q2 {
    public static void main(String[] args) {
        String a = new String("abcdcba");
        if (isPalindrome(a, 0, a.length()-1))
            System.out.println(a + " is a palindrome");
        else
            System.out.println (a + " is NOT a palindrome");
    }
    public static boolean isPalindrome (String x, int i, int j ){
        if (i<(x.length()-1)) {
            if (x.charAt(i)!= x.charAt(j)) return false;
            else {
                isPalindrome(x,i+1,j-1);
            }
        }
        return (true);
    }
}
