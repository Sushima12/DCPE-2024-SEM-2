import java.util.Arrays;

public class Activity3_3 {
    public static void main(String[] args){
        RunPrintMachine();
    }
    static class PrintMachine {
        public static int totalNoOfCopy;
        //records the total number of copies made from all the
        // print machines
        public String[] copy(String strText, int intNos) {
            totalNoOfCopy = intNos;
            // and return a String array with all its
            // element value being strText and array size being intNos
            String[] Copies = new String[intNos]; // Create String Array with size int Nos
            for (int x = 0; x < intNos; x++) {
                Copies[x] = strText;
            }

            return Copies;
        }
    }

    public static void RunPrintMachine() {
        //Canon Printer
        PrintMachine Canon = new PrintMachine();
        System.out.println(Arrays.toString(Canon.copy("Flying!", 6)));
        System.out.println("Total Number of Copies (Canon): " + PrintMachine.totalNoOfCopy);

        //Fujitsu Printer
        PrintMachine Fujitsu = new PrintMachine();
        System.out.println(Arrays.toString(Fujitsu.copy("High!", 8)));
        System.out.println("Total Number of Copies (Fujitsu): " + PrintMachine.totalNoOfCopy);

    }
}
