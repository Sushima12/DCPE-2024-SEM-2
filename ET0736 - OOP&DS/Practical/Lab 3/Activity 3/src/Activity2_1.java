public class Activity2_1 {
    public static void main(String[] args) {
        Die D1= new Die(6);
        int result = D1.roll();
        System.out.println("Rolling Dice...");
        System.out.println("Result: " + result);
    }

    static class Die {
        int maxFace;
        public Die (int n){
            maxFace = n;
        }
        int roll () {
            //Roll dice
            return (int) (Math.random() * maxFace) + 1;
        }
    }
}
