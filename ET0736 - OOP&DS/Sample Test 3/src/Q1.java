import java.util.ArrayList;

public class Q1 {
    public static void main(String[] args) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        //Vertex A
        a.adjList.add(b);
        a.adjList.add(c); // write your answers in space below

        //Vertex B
        b.adjList.add(d);

        //Vertex C
        c.adjList.add(a);

        //Vertex D
        d.adjList.add(c);
    }
}
class Vertex{
    String label;
    ArrayList<Vertex> adjList = new ArrayList<>();
    Vertex (String label) {
        this.label = label;
    }
}