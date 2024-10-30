public class Activity3_3 {
    class PrintMachine {
        public static int totalNoOfCopy = 0;
        //records the total number of copies made from all the
        // print machines
        public String[] copy(String strText, int intNos) {


            // and return a String array with all its
            // element value being strText and array size being intNos
            String[] Copies = new String[intNos]; // Create String Array with size int Nos
            while (true) {
                Copies[totalNoOfCopy] = strText;
                
            }
        }
    }

    class RunPrintMachine {
        PrintMachine Canon = new PrintMachine();
        PrintMachine Fujitsu = new PrintMachine();

    }
}
