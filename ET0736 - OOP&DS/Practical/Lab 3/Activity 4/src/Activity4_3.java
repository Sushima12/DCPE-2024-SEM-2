public class Activity4_3 {
    public static void main(String[] args) {
        Boat b = new Boat("50","WhiteSand", "Sea", "Raffles Marina");
        setModeOfTravel(b);
    }
    public static void setModeOfTravel(Transportation t){
        t.move();
    }

}

class Transportation {
    String speed;
    String name;
    String type; // land, sea or air
    public Transportation(String speed, String name, String type) {
        this.speed = speed;
        this.name = name;
        this.type = type;
    }
    void move(){
        System.out.println ("Moving in "+ type + " at speed of " + speed);
    }
}

class Boat extends Transportation {
    String basePort;
    // complete the class
    Boat(String speed, String name, String type, String basePort) {
        super(speed, name, type);
        this.basePort = basePort;
    }

    void move() {
        //Polymorphism
        System.out.println ("Moving in "+ type + " at speed of " + speed);
        System.out.println ("The base port for "+ name + " is " + basePort);
    }
}
