

public class Activity8_3 {
    public static void main(String[] args) {
        MyLinkedList<Integer> aList = new MyLinkedList<>();
        for (int x = 1; x <= 5; x++) {
            aList.append(x);
        }
        System.out.println(aList);
    }
}

class MyLinkedList<E> {
    Node<E> head = null;
    Node<E> current = null;
    Node<E> newNode;
    Node<E> tail = null;
    public void append (E x){
        newNode = new Node<E> (x);
        if (head==null) {
            // for very first mode
            head = new Node(x);
        } else {
            current = head;
            // track down to tail node
            while (current.next != null)
                current = current.next; // add in the new node
            current.next = newNode;
        }


    }
    public String toString(){
        String s = "";
        current = head;
        while (current!=null) {
            s += current.data.toString();
            current = current.next;
        }
        return (s);
    }
}
class Node<E> {
    E data;
    Node<E> next = null;
    Node<E> previous = null;
    Node (E data) {
        this.data = data;
    }
}
