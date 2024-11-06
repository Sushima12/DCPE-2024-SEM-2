public class Activity4_4 {
    public static void main(String[] args) {
        Boat b = new Boat("50","WhiteSand", "Sea", "Raffles Marina");
        //Activity 4-4
        Boat alpha = new Boat("20", "Alpha", "Sea", "Port Sarim");
        Boat beta = new Boat("45", "Beta", "Sea", "Port Ph");
        setModeOfTravel(b);
    }
    public static void setModeOfTravel(Transportation t){
        t.move();
    }
}
