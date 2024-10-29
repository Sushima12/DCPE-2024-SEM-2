public class Main {
    public static void main(String[] args) {
        String a[] ={"aaa","qqq","AAA","QQQ"};
        String temp;
        for (int x = 0; x < a.length - 1; x++){
            for (int n = 0; n < a.length - 1; n++){
                if (a[n].compareTo(a[n+1]) > 0) {
                    //Swap
                    temp = a[n+1];
                    a[n+1] = a[n];
                    a[n] = temp;
                }
            }
        }
        for (int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}