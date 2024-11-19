public class Dog extends HousePet {
    protected int numberOfWalksPerDay;
    public Dog(){
        //This calls HousePet() automatically.
        numberOfWalksPerDay = 2;
    }
    public Dog(String n, String o, String ff, int numWalks){
        //We must explicitly call the HousePet() overloaded
        //constructor, passing it the name, owner, and food info.
        super(n,o,ff);
        numberOfWalksPerDay = numWalks;
    }
    /*Here are the two methods that are abstract in the superclass,
    which are overriden here, thus making Dog a complete class*/
    public String where_I_Sleep(){
        /*add codes here to implement the method—describe how a Dog sleep*/
        return "I Sleep on my bed";
    }
    public String how_I_Move(){
        /*add codes here to implement the method—describe how a Dog move*/
        return "I run with my 4 legs :P";
    }
    public String toString(){
        String output = super.toString()
                +"\nMy owner walks me " + numberOfWalksPerDay + " times a day.";
            /*modify coded here to override toString method---provide
            complete description of a Dog*/
        return output;
    }
}
