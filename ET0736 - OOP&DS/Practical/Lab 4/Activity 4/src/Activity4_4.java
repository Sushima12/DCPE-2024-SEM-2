import java.util.ArrayList;
import java.util.Comparator;

public class Activity4_4 {
    public static void main(String[] args) {
        Boat b = new Boat("50","WhiteSand", "Sea", "Raffles Marina");
        //Activity 4-4
        Boat alpha = new Boat("20", "Alpha", "Sea", "Port Sarim");
        Boat beta = new Boat("45", "Beta", "Sea", "Port Ph");

        //Boat Array List
        ArrayList<String> BoatArray = new ArrayList<>();
        BoatArray.add(b.toString());
        BoatArray.add(alpha.toString());
        BoatArray.add(beta.toString());

        //BoatArray.sort(new SortBoatName());
    }
}
/*
class SortBoatName implements Comparator<String> {

    public void compare(ArrayList<String> BoatArrayList) {
        String temp;
        for (int i = 0; i < BoatArrayList.size(); i++) {
            if (a[n].compareTo(a[n+1]) > 0) {
                //Swap
                temp = a[n+1];
                a[n+1] = a[n];
                a[n] = temp;
            }
        }
    }
}*/




