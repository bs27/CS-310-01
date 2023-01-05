package ObjectOrientedDesign;
//
public class Main {
//    Calculating	PI
//    Background
//    The number π (Pi) is a mathematical constant originally define as the ratio of a circle’s
//    circumference to its diameter, approximately 3.1415926. [https://en.wikipedia.org/wiki/Pi] Since
//    that original definition various ways to compute the value of π have been discovered. In this
//    assignment you will implement some of those methods.
//    The	Problem
//    Write a program to compute the value of π using the following methods:
//            1. The ratio of a circle’s circumference and diameter
//2. The Gregory-Liebniz series

//3. The Nilakantha series
//4. Buffon’s Needle process
//5. Dart Throwing process
//6. The limit of large numbers concept
//7. The arcsine concept.
//    You can find descriptions of these processes here [https://www.wikihow.com/Calculate-Pi] and
//    here [http://www.thephysicsmill.com/2014/05/03/throwing-darts-pi/], as well as many other
//    websites. If you find these descriptions lacking or difficult to follow you may seek other
//    descriptive sources.
//    The program’s output may look something like this:
//    Circumference/Diameter: 3.1415939025
//    Gregory-Liebniz: 3.141592153589724
//    Nilakantha: 3.49635588787317
//    Buffons Needle: 3.138416731527279
//    Dart Throwing: 3.142936
//    Large Limit: 3.141592653588502
//    Arcsine: 3.141592653589793
//    Some of the techniques are iterative in which case you will need to decide how many iterations
//    to use to get the value close to the known value of π.
//            Deliverables
//1. Your source code (.java) files for each class.
//            2. A reflective essay describing
//    a. Successes
//    b. Difficulties and how you overcame them
    public static void main(String[] args) {
        double circumferance = 6.283185;
        double diameter = 2;
        System.out.println("Circumference/Diameter  : " + CircAndDirk(circumferance , diameter) );
        double fourthPi = GregoryLiebniz(1.0);
        System.out.println("Gregory-Liebniz: " + fourthPi * 4.0);
        double PiOfNil = Nilakantha(3.0);
        System.out.println("Nilakantha : " + PiOfNil);
        System.out.println("Buffons Needle:  " + beginBSSIM() );
        System.out.println("Dart Throwing Simulation: " + (beginDartThrowingSim() * 4.0));
        System.out.println("Limit of Large Numbers : " + limitOfLargeNumber((double) 100000000));
        double arcsine = arcsine((Math.random() * 2)-1);
        System.out.println("Concept of Arcsine : " + arcsine);

    }

    private static double CircAndDirk(double circumferance, double diameter) {
        return circumferance/diameter;
    }


    private static double beginBSSIM() {
        double distance;
        double angleOfDrop;
        double countofAll = 0;
        double countofHit = 0;
        for (int i = 0; i < 999999999; i++){
            distance = Math.random()/2.0;
            angleOfDrop = Math.random()*180.0;
            if (distance <= ((0.5) * Math.sin(Math.toRadians(angleOfDrop)))) {
                countofHit++;
                countofAll++;
            } else {
                countofAll++;
            }

        }
        return ((countofAll)*2/countofHit);
    }

    private static double beginDartThrowingSim() {

        double xCoordinate;
        double yCoordinate;
        double countofAll = 0;
        double countofHit = 0;
        //Begin Loop

        //d=square root(x2−x1)^2+(y2−y1)^2
        for (int i = 0; i < 999999999; i++) {
            xCoordinate = Math.random()*2;
            yCoordinate = Math.random()*2;
            if (1.0 >= Math.sqrt(Math.pow((xCoordinate - 1), 2) + Math.pow((yCoordinate - 1), 2))) {
                countofAll++;
                countofHit++;
            } else {
                countofAll++;
            }

        }
        return (countofHit/ countofAll);
    }


    private static double limitOfLargeNumber(Double AVeryLargeNumber) {
        double pi = Math.toRadians((AVeryLargeNumber) * Math.sin(180 / AVeryLargeNumber));
        return pi;
    }
    private static double arcsine(double v) {
        double pi = 2 * (Math.asin(Math.sqrt(1 - Math.pow(v,2))) + Math.abs(Math.asin(v)));
        return pi;
    }

    private static double GregoryLiebniz(double x) {
        //This series takes a lot of terms Must be mulitplied by four.
        double y = x;
        boolean f = true;
        double fourthOfPi = x;
        for (int i = 0; i < 999999999; i++) {
            if (f) {
                y += 2.0;
                fourthOfPi = (fourthOfPi - x / y);
                f = false;
            } else {
                y += 2.0;
                fourthOfPi = fourthOfPi + (x / (y));
                f = true;
            }
        }
        return fourthOfPi;
    }

        private static double Nilakantha(double x){
            //This series gets pi faster supposedly
            double y = x + 1.0;
            double pi = x;
            boolean f = true;
            for(int i = 0; i < 999999999; i++) {
                if (f) {
                    x = x + (y / ( (y-2.0) * (y-1.0) * y));
                    y = y + 2.0;
                    f = false;
                } else {
                    x = x - (y / (y * (y-1.0) * (y-2.0)));
                    y = y + 2.0;
                    f = true;
                }
            }
            return x;
    }

}
