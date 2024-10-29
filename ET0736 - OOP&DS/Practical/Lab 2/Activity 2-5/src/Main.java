public class Main {
    public static void main(String[] args) {
        int [] a = {-8, -1, 23, 54, 59, 71, 88};
        int [] b = {-8, -1, 23, 54, 59, 71, 88, 200};
        int key = 200;

        //Call BinarySearch() Method
        System.out.println("Array a:");
        BinarySearch(a, key);
        System.out.println("-------------------------------------");
        System.out.println("Array b:");
        BinarySearch(b, key);

    }

    public static void BinarySearch(int [] array, int key) {
        //Binary Search
        int Index_Middle_Element; //Index of middle element
        if (array.length % 2 == 0) {
            //Even Number of Array Length
            Index_Middle_Element = (array.length / 2);

        } else {
            //Odd Number of Array Length
            Index_Middle_Element = (array.length / 2) + 1;
        }
        int Middle_Key = array[Index_Middle_Element];

        while (true){

            if (key == Middle_Key){
                // Key found
                System.out.println("Key Found!");
                System.out.println("Index of key: " + Index_Middle_Element);
                break;
            }else if (key < Middle_Key) {
                //Continue Search in the left direction
                if ( key > ( array[Index_Middle_Element - 1]) && !((Index_Middle_Element - 1) < 0)){
                    //Check key in next index to prevent Loop
                    System.out.println("Key Not Found (Loop Prevention)");
                    break;
                }
                Index_Middle_Element = Index_Middle_Element - 1;
                if (Index_Middle_Element < 0) {
                    System.out.println("Key Not Found (End of Index)");
                    break;
                }
                Middle_Key = array[Index_Middle_Element];
            } else {
                //Continue Search in the right direction
                if (key > (array[Index_Middle_Element + 1]) && !((Index_Middle_Element + 1) > array.length)) {
                    //Check key in next index to prevent Loop
                    System.out.println("Key Not Found (Loop Prevention)");
                    break;
                }
                Index_Middle_Element = Index_Middle_Element + 1;
                if (Index_Middle_Element == array.length) {
                    System.out.println("Key Not Found (End of Index)");
                    break;
                }
                Middle_Key = array[Index_Middle_Element];
            }
        }
    }
}