public class Main {
    public static void main(String[] args) {
        //Activity 2-2
        //randomly generate an integer and
        //invoke the method to get the reversed value and display it.

        int random_number;
        random_number = (int) Math.round(Math.random()*100);
        System.out.println("Random Number: " + random_number);
        System.out.println("Reverse: " + reverse(random_number));

    }

    public static int reverse(int number) {
        //To display the number in reverse order
        String number_string;
        String reverse_string = "";
        int reverse_number;

        //Convert number from int to string
        number_string = String.valueOf(number);
        
        for (int x = number_string.length() - 1; x >= 0; x--){
            reverse_string += number_string.charAt(x);
        }
        reverse_number = Integer.parseInt(reverse_string);
        return reverse_number;
    }
}