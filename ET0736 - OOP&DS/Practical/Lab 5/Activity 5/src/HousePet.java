public abstract class HousePet {
    protected String name, favoriteFood, owner;
    public HousePet(){
        //We'll name all of our pets Pooky initially.
        name = "Pooky";
        //We'll assume Donna owns all of the pets.
        owner = "Donna";
        //We'll assume all of our pets like cookies.
        favoriteFood = "cookies";
    }
    //Here is our overloaded constructor.
    public HousePet(String n, String o, String ff){
        name = n;
        favoriteFood = ff;
        owner = o;
    }
    //These abstract methods must be overidden in the subclasses
    public abstract String where_I_Sleep();
    public abstract String how_I_Move();
    public void setName(String n) { name = n; }
    public void setFavoriteFood(String ff) { favoriteFood = ff; }
    public void setOwner(String o) { owner = o; }
    public String toString(){ {
        String output = "I am " + name + ", a house pet. "
                +"\nMy favorite food is " + favoriteFood
                +".\nMy owner is " + owner +".";
        return output;
    }}
}
