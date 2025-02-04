import java.util.*;

//Activity 9-1
public class BFS_manual {
    public static ArrayList<ArrayList<Vertex>> overall = new ArrayList<ArrayList<Vertex>>();
    public static void main(String[] args) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        a.adjList.add(b);
        a.adjList.add(c);
        a.adjList.add(d);
        b.adjList.add(a);
        c.adjList.add(a);
        c.adjList.add(e);
        d.adjList.add(a);
        d.adjList.add(e);
        e.adjList.add(c);
        e.adjList.add(d);

        Set<Vertex> isVisited = new HashSet<>();
        ArrayList<Vertex> pathList = new ArrayList<>(); // arbitrary source and destination
        Vertex source = b;
        Vertex dest = e;
        isVisited.add(source);
        pathList.add(source);
        bfs(source,dest,isVisited,pathList);
        if (overall.size()==0) System.out.println("No path found");
        else { System.out.println( "Following are all different paths from "
                + source.label + " to " + dest.label);
            // Code to print out all paths from overall
        }
    }
}

private static void bfs(Vertex u, Vertex d, Set<Vertex> isVisited, ArrayList<Vertex> localPathList) {
    if (u.label.equals(d.label)){
        // Code to add localPathList into overall
        return;
    }
    Vertex temp=null;
    ArrayDeque<Vertex> localQ = new ArrayDeque<>();
    u.adjList.forEach(eee->localQ.addFirst(eee));
    while (!localQ.isEmpty()){
        // Code to manage localPathList, ArrayDeque, isVisited and recursive call of bfs
        return;
    }
}

class Vertex{
    String label;
    ArrayList<Vertex> adjList = new ArrayList<>();
    Vertex (String label) {
        this.label = label;
    }
}

