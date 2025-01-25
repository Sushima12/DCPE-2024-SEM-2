import java.util.Arrays;

public class Activity8_1_and_2 {
    public static void main(String[] args) {
        MyArrayList<Integer> a = new MyArrayList<>();
        for (int n = 1; n <= 15; n++) {
            a.add(n);
        }
        for (int n = 0; n <= a.size() - 1; n++) {
            
            System.out.println(a.get(n));
        }
        System.out.println(a.size());
        a.remove(5);
        for (int n = 0; n <= a.size() - 1; n++) {
            System.out.println(a.get(n));
        }
    }
}
class MyArrayList<E> {
    int INITIAL_CAPACITY = 10;
    E a[] = (E[]) new Object[INITIAL_CAPACITY];

    void add(E x) {
        if (a[a.length - 1] == null) {
            int i = 0;
            while (a[i] != null) {
                i++;
            }
            a[i] = x;
        } else {
            // increase size by 10
            int originalSize = a.length;
            int newSize = originalSize + 10;
            E b[] = (E[]) new Object[newSize];
            b = Arrays.copyOf(a, newSize);
            a = b;
            a[originalSize] = x;
        }
    }

    E get(int index) {
        return (a[index]);
    }

    //Activity 8-1
    int size() {
        int n=0;
        while(a[n] != null) {
            n++;
        }
        return n;
    }

    //Activity 8-2
    int remove(int index) {
        if (index >=0 && index < size() - 1) {
            E a_copy[] = null;
            int x = 0;
            for (int i = 0; i < size() - 1; i++) {
                if (i != index) {
                    a_copy[x] = a[i];
                    x++;
                }
            }
            for (int i = 0; i < a_copy.length - 1;i++) {
                a[i] = a_copy[i];
            }
            return 0;
        }else {
            return -1;
        }
    }
}
