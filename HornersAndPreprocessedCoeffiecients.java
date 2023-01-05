package ObjectOrientedDesign;

import java.io.FileWriter;
import java.io.IOException;

public class HornersAndPreprocessedCoeffiecients {
    public static void main(String[] args) throws IOException {
        FileWriter steve = new FileWriter("C:\\Users\\bjsot\\Desktop\\Algorithims\\src\\ObjectOrientedDesign\\hornerAndPre.csv");
        // coefficent list 1 , 4 , 0 , 8 , 6 , 9 , 2 , 3
        double[] coeffiecientList = new double[]{1.0 , 4.0 , 0 , 8.0 , 6.0 , 9.0 , 2.0 , 3.0};
        //Needed loop increment was inaccurate due to contiued addition of .2 and nature
        double[] pList = new double[]{-20.0,-19.8,-19.6,-19.4,-19.2,-19.0,-18.8,-18.6,-18.4,-18.2,-18.0,-17.8,-17.6,-17.4,-17.2,-17.0,-16.8,-16.6,-16.4,-16.2,-16.0,-15.8,-15.6,-15.4,-15.2,-15.0,-14.8,-14.6,-14.4,-14.2,-14.0,-13.8,-13.6,-13.4,-13.2,-13.0,-12.8,-12.6,-12.4,-12.2,-12.0,-11.8,-11.6,-11.4,-11.2,-11.0,-10.8,-10.6,-10.4,-10.2,-10.0,-9.8,-9.6,-9.4,-9.2,-9.0,-8.8,-8.6,-8.4,-8.2,-8.0,-7.8,-7.6,-7.4,-7.2,-7.0,-6.8,-6.6,-6.4,-6.2,-6.0,-5.8,-5.6,-5.4,-5.2,-5.0,-4.8,-4.6,-4.4,-4.2,-4.0,-3.8,-3.6,-3.4,-3.2,-3.0,-2.8,-2.6,-2.4,-2.2,-2.0,-1.8,-1.6,-1.4,-1.2,-1.0,-0.8,-0.6,-0.4,-0.2,0.0,0.2,0.4,0.6,0.8,1.0,1.2,1.4,1.6,1.8,2.0,2.2,2.4,2.6,2.8,3.0,3.2,3.4,3.6,3.8,4.0,4.2,4.4,4.6,4.8,5.0,5.2,5.4,5.6,5.8,6.0,6.2,6.4,6.6,6.8,7.0,7.2,7.4,7.6,7.8,8.0,8.2,8.4,8.6,8.8,9.0,9.2,9.4,9.6,9.8,10.0,10.2,10.4,10.6,10.8,11.0,11.2,11.4,11.6,11.8,12.0,12.2,12.4,12.6,12.8,13.0,13.2,13.4,13.6,13.8,14.0,14.2,14.4,14.6,14.8,15.0,15.2,15.4,15.6,15.8,16.0,16.2,16.4,16.6,16.8,17.0,17.2,17.4,17.6,17.8,18.0,18.2,18.4,18.6,18.8,19.0,19.2,19.4,19.6,19.8,20.0};
//        for(double x = -20.0; x <= 20.0; x += 0.20){
        // to be pasted into an excel
        steve.append("p Value").append(",").append("Horners Method Evaluation");
        steve.append(",");
        steve.append("p Value").append(",").append("Preprocessed Coefficients Method Evaluation");
        steve.append("\n");
        
        for(double x : pList){
            steve.append(String.valueOf(x)).append(",").append(String.valueOf(hornersMethod(x, coeffiecientList)));
            steve.append(",");
            steve.append(String.valueOf(x)).append(",").append(String.valueOf(preprocessedCoefficients(x)));
            steve.append("\n");
        }
        steve.flush();
        steve.close();







    }

    private static double preprocessedCoefficients(double x) {

        //insert easier calc bellow

        double[] x4 = new double[]{1 , 0 , 0 , 0 , 5};
        double[] x5 = new double[]{1 ,0, -1};
        double[] x6 = new double[]{1 , 4};
        double[] x7 = new double[]{1 , 12};
        double[] x8 = new double[]{1 ,0, 1};
        double[] x9 = new double[]{1 , -11};
        double[] x10 = new double[]{1 , -26};
        double x4a = hornersMethod(x, x4);
        double x2a = ((hornersMethod(x,x5) * hornersMethod(x,x6)) + hornersMethod(x,x7));
        double x2b = ((hornersMethod(x,x8)*hornersMethod(x,x9)) + hornersMethod(x,x10));
        return ((x4a * (x2a)) + x2b);










       /* WRONG CODE DO NOT USE -- Algorithmic implementation From Book Substition -- NWRONG CODE DO NOT USE
        double x4 = ((x*x*x*x)+5);
        double x2a = ((((x*x) - 1) * (x + 4)) + (x - 4));
        double x2b = ((((x*x)+1)*(x -11)) + (x + 48));
        return ((x4 * x2a)+x2b);*/
         /*double x4 = ((x*x*x*x)+5);
        double x2a = ((((x*x) - 1) * (x + 4)) + (x - 4));
        double x2b = ((((x*x)+1)*(x -11)) + (x + 48));
        return ((x4 * x2a)+x2b);*/

        //return ((((x * x * x * x) + 5.0 ) * (((x*x) - 1.0)*(x + 4.0)+(x - 4.0))) + (((x * x) + 1.0)*(x - 11.0)+(x + 48.0)));

        
    }

    private static double hornersMethod(double x, double[] coeffiecientList) {
        int n = 0;
        double result = coeffiecientList[n];
        for (int i = n + 1; i <= coeffiecientList.length - 1; i++){
            result = result * x;
            result = result + coeffiecientList[i];
        }
        return result;
    }



}
