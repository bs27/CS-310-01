package ObjectOrientedDesign;
import java.util.Scanner;
//Code modified from Problem 2
class Problem3Part1 {
    public static void main(String[] args) throws Exception {
        boolean appRunning = true;
        String response;
        int[] allnumbs;
        int amountOfNums;
        Scanner newSC = new Scanner(System.in);
 /*       int choice;

        System.out.println("Type 1 for Counting Numbers up");
        System.out.println("Type 2 for Mean and Standard Deviation and Mean Calculations");
        System.out.println("Type 3 for both");
        choice = newSC.nextInt();
*/        while (appRunning == true){
            try {

                System.out.println("Enter Number of Dice Rolls");
                amountOfNums = newSC.nextInt();
            }catch (Exception e){
                throw new Exception(e);

            }
            allnumbs = new int[amountOfNums];
            for (int i = 0; i < amountOfNums; i++){
                allnumbs[i] = (int)(Math.random()*8)+1;

            }
            countAllNums(allnumbs);
/*            switch (choice) {
                case 1 -> countAllNums(allnumbs);
                //case 2 -> getMeanAndSD(allnumbs);
                *//*case 3 -> {
                    countAllNums(allnumbs);
                    getMeanAndSD(allnumbs);
                }*//*
            }*/
            System.out.println(" Continue: Y or N");
            response = newSC.next();
            if (response.equals("N")){
                System.out.println("Have a Nice Day!");
                appRunning = false;
            }
            //Generate N random numbers in the range of [1..6]
            //b. Count the number of times each random number appears
            //c. Print out the counts
            //d. Do this for N = 60, 600, 6000, 60000, 600000, 6000000
            //i. N will be input from the keyboard by the user







        }



    }

    /*private static void getMeanAndSD(int[] allnumbs) {
        int length = allnumbs.length;
        int number = 0;
        double sumInSD = 0;
        double mean = 0;
        //Mean opp
        for (int i = 0; i < length; i++){
            number = allnumbs[i];
            mean += number;
        }
        mean = mean/length;
        System.out.println("Mean : " + mean);
        for (int i = 0; i < length; i++){
            number = allnumbs[i];
            sumInSD += Math.pow((number - mean),2);
        }
        System.out.println("Standard Deviation: " + Math.sqrt(sumInSD/length));
    }*/


    private static void countAllNums(int[] allnumbs) {
        int length = allnumbs.length;
        int number = 0;
        int ones = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        int fives = 0;
        int totalCount = 0;
        for (int i = 0; i < length; i++){
            number = allnumbs[i];
            switch (number){
                case 1:
                    ones++;
                    totalCount++;
                    break;
                case 2:
                    twos++;
                    totalCount++;
                    break;
                case 3:
                case 4:
                    threes++;
                    totalCount++;
                    break;
                case 5:
                    fours++;
                    totalCount++;
                    break;
                case 6:
                case 7:
                case 8:
                    fives ++;
                    totalCount++;
                    break;
            }
        }
        System.out.println("Ones Generated : " + ones);
        System.out.println("Observed Probabilty = "+ ones + " / " + totalCount + " = " + ((double)ones/totalCount));
        System.out.println("Twos Generated : " + twos);
        System.out.println("Observed Probabilty = "+ twos + " / " + totalCount + " = " + ((double)twos/totalCount));
        System.out.println("Threes Generated : " + threes);
        System.out.println("Observed Probabilty = "+ threes + " / " + totalCount + " = " + ((double)threes/totalCount));
        System.out.println("Fours Generated : "+ fours);
        System.out.println("Observed Probabilty = "+ fours + " / " + totalCount + " = " + ((double)fours/totalCount));
        System.out.println("Fives Generated : " + fives);
        System.out.println("Observed Probabilty = "+ fives + " / " + totalCount + " = " + ((double)fives/totalCount));
        System.out.println(((double)ones/totalCount) + " + " + ((double)twos/totalCount) + " + " + ((double)threes/totalCount) + " + " +((double)fours/totalCount) + " + " + ((double)fives/totalCount) + " = " + (((double)ones/totalCount) + ((double)twos/totalCount) + ((double)threes/totalCount) +((double)fours/totalCount) + ((double)fives/totalCount) ));

    }

}