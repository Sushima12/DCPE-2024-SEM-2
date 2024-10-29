import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Activity 1-6
        //Hidden Apollo 13
        String input_text;
        String phrase = "Apollo 13";
        int option;
        Scanner sc;
        System.out.println("Options");
        System.out.println("1. Single Phrase Search Function");
        System.out.println("2. Multiple Phrase Search Function");
        //Read Option
        sc = new Scanner(System.in);
        System.out.println("Choose Option (1 or 2): ");
        option = sc.nextInt();

        //Read Input Text
        sc = new Scanner(System.in);
        System.out.println("Enter Text: ");
        input_text = sc.nextLine();
        if (option == 1) {
            //Option 1: Single Phrase
            if (search_single_phrase(input_text, phrase) == -1) {
                //Display Not Found
                System.out.println("Not Found");
            } else {
                //Print Index
                System.out.println("Index: " + search_single_phrase(input_text, phrase));
            }
        } else if (option == 2) {
            //Option 2: Multiple Phrase
            search_multiple_phrase(input_text, phrase);
        }

    }
    //Method for finding 1 phrase
    public static int search_single_phrase(String input_text, String phrase) {
        int index; //index to be returned that was first found
        if (input_text.contains(phrase)) {
            //Note: Index starts from 0!
            index = input_text.indexOf(phrase);
            return index;
        } else {
            //Does not contain the phrase
            // Return -1
            return -1;
        }
    }

    //Method for finding multiple phrases
    public static void search_multiple_phrase(String input_text, String phrase) {

        int start_index;
        String scanned_text; // To scan the text
        if (input_text.contains(phrase)) {
            start_index = input_text.indexOf(phrase);
            System.out.println("Phrase is found at the following indices: ");
            for (int x = 0; x < (input_text.length()- start_index); x++) {
                //start_index count, end_index not count
                scanned_text = input_text.substring(start_index, (start_index + phrase.length()));
                if (scanned_text.equals(phrase)) {
                    //Display Index
                    System.out.println(start_index);
                    start_index = start_index + phrase.length();
                } else {
                    start_index = start_index + 1;
                }
            }
        } else {
            //Does not contain the phrase
            //Display Not found
            System.out.println("Not Found");
        }
    }
}