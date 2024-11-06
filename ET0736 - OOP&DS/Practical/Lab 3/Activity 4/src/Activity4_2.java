public class Activity4_2 {
    public static void main(String[] args) {
        Rose r = new Rose ("Pink","Damascus","Majolica","Happiness");
        // Color, Origin, Name, Meaning
    }
}

class Flower {
    String color;
    String origin;
    public Flower(String color, String origin) {
        this.color = color;
        this.origin = origin;
    }
}

class Rose extends Flower {
    String name;
    String meaning;
    // complete the constructor
    Rose(String color, String origin, String name, String meaning) {
        super(color, origin);
        this.name = name;
        this.meaning = meaning;
    }
}
