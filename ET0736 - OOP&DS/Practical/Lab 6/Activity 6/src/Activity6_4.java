import java.util.HashMap;

class Student {
    String adm;
    double GPA;
    HashMap<Integer, String> choices ;
    public Student(String adm, double GPA, HashMap<Integer, String> choices) {
        this.adm = adm;
        this.GPA = GPA;
        this.choices = choices;
    }
}
public class Activity6_4{
    public static void main(String[] args) {
        HashMap<Integer, String> c1 = new HashMap<>();
        c1.put(1,"IoT");
        c1.put(2, "AI");
        c1.put(3,"Web");
        HashMap<Integer, String> c2 = new HashMap<>();
        c2.put(1,"IoT");
        c2.put(2, "AI");
        c1.put(3,"Web");
        HashMap<Integer, String> c3 = new HashMap<>();

        Student s1 = Student("P12345",
                4.0,
                )
    }
}
