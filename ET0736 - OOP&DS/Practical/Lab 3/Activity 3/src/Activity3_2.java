public class Activity3_2 {
    public static void main(String[] args) {
        double result_1, result_2;
        TwoDPoint P1 = new TwoDPoint(10, 10);
        TwoDPoint P0 = new TwoDPoint();
        result_1 = TwoDPoint.getDistance(P1);
        result_2 = TwoDPoint.getDistance(P0);
        System.out.println(result_1);
        System.out.println(result_2);
    }
    static class TwoDPoint {
        private double x;
        private double y;

        TwoDPoint () {
            //No arg constructor
            //(0,0)
            x = 0;
            y = 0;
        }

        TwoDPoint (double x, double y) {
            this.x = x;
            this.y = y;
        }


        public double getx() {
            return(x);
        }
        public double gety() {
            return(y);
        }

        public static double getDistance(TwoDPoint remotePoint) {
            //TwoDPoint remotePoint is like SpStudent s1
            double distance;
            distance = Math.sqrt(Math.pow(remotePoint.getx(),2) + Math.pow(remotePoint.gety(),2));
            return distance;
        }
    }
}
