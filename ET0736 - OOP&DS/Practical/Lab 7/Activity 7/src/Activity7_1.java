public class Activity7_1 {
    public static String R = "";
    public static void main(String[] args) {
        System.out.println(convert(4));
    }

    //to convert decimal to binary
    public static String convert(int x) {
        if (x % 2 == 0) {
            if (x/2 != 0) {
                convert(x / 2);
            }
            R += "0";//maggicks i dk how it works
        } else if (x % 2 > 0) {
            if (x/2 != 0) {
                convert(x / 2);
            }
            R += "1";//put below (magick)
        }
        return R;
    }
}
