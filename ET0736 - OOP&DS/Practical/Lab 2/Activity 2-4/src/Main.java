public class Main {
    public static void main(String[] args) {
        int a[] = {88, -8, -1, 59, 54, 71, 23};
        int b[] = {59, -1, 54, 23, -8, 71, 88, 200};
    }

    public static void BubbleSort(int[] array) {
        int temp;
        for (int x = 0; x < array.length - 1; x++){
            for (int n = 0; n < array.length - 1; n++){
                if (array[n] > array[n+1]) {
                    //Swap
                    temp = array[n+1];
                    array[n+1] = array[n];
                    array[n] = temp;
                }
            }
        }
        for (int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
}