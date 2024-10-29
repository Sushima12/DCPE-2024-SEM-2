

public class Main {
    public static void main(String[] args) {
        //Activity 2.1
        //Math API
        float sin_x, cos_x;
        int x = 0; //Degrees
        System.out.println("Degree\t" + "sin\t" + "cos");

        while (x <= 360) {

            sin_x = (float) Math.sin(Math.toRadians(x));
            cos_x = (float) Math.cos(Math.toRadians(x));
            System.out.printf("%d\t\t", x);
            System.out.printf("%5.4f\t\t", sin_x);
            System.out.printf("%5.4f\t\t\n", cos_x);
            x += 10;
        }

    }
}