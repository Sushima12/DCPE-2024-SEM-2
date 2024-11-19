public class Activity4_1 {
    public static void main(String[] args) {
        //2D point
        TwoDPoint P1 = new TwoDPoint(10, 10);
        TwoDPoint remotePointA = new TwoDPoint(20,20);

        System.out.println("P1 and RemotePointA distance: " + P1.getDistance(remotePointA));

        //3D Point
        ThreeDPoint P2 = new ThreeDPoint(10, 10, 10);
        ThreeDPoint remotePointB = new ThreeDPoint(30, 30, 30);

        System.out.println("P2 and RemotePointB distance: " + P2.getDistance(remotePointB));
    }
}


class TwoDPoint {
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


    public double getX() {
        return(x);
    }
    public double getY() {
        return(y);
    }

    public double getDistance(TwoDPoint remotePoint) {
        //TwoDPoint remotePoint is like SpStudent s1
        double distance;
        distance = Math.sqrt(Math.pow(remotePoint.getX() - this.x,2) + Math.pow(remotePoint.getY()- this.y,2));
        return distance;
    }
}

class ThreeDPoint extends TwoDPoint {
    private double z;
    ThreeDPoint() {
        super();
        z = 0;
    }
    ThreeDPoint(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public double getDistance(ThreeDPoint remotePoint) {
        double distance;
        distance = Math.sqrt(Math.pow(remotePoint.getX() - this.getX(),2) + Math.pow(remotePoint.getY() - this.getY(),2) + Math.pow(remotePoint.getZ() - this.getZ(),2));
        return distance;
    }
}

