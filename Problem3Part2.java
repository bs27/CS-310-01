package ObjectOrientedDesign;
import java.util.Scanner;
//Code modified from Problem 2
class Problem3Part2 {
    public static void main(String[] args) throws Exception {
        boolean appRunning = true;
        String response;
        int[] allnumbs;
        int d1;
        int d2;
        int amountOfNums;
        //Code is an algmation of Problem2Part two and problem 3 part1
        Scanner newSC = new Scanner(System.in);
 /*       int choice;

        System.out.println("Type 1 for Counting Numbers up");
        System.out.println("Type 2 for Mean and Standard Deviation and Mean Calculations");
        System.out.println("Type 3 for both");
        choice = newSC.nextInt();
*/
        while (appRunning) {
            try {

                System.out.println("Enter Number of Dice Rolls");
                amountOfNums = newSC.nextInt();
            } catch (Exception e) {
                throw new Exception(e);

            }
            allnumbs = new int[amountOfNums];
            for (int i = 0; i < amountOfNums; i++) {
                d1 = (int) (Math.random() * 8) + 1;
                d2 = (int) (Math.random() * 8) + 1;
                d1 = trueValue(d1);
                d2 = trueValue(d2);
                allnumbs[i] = d1 + d2;
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
            if (response.equals("N")) {
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

    private static int trueValue(int d1) {
        return switch (d1) {
            case 1 -> 1;
            case 2 -> 2;
            case 3, 4 -> 3;
            case 5 -> 4;
            case 6, 7, 8 -> 5;
            default -> -1;
        };
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
        int number ;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        int fives = 0;
        int sixes = 0;
        int sevens = 0;
        int eights = 0;
        int nines = 0;
        int tens = 0;
        int totalCount = 0;
        for (int allnumb : allnumbs) {
            number = allnumb;
            switch (number) {
                case 2 -> {
                    twos++;
                    totalCount++;
                }
                case 3 -> {
                    threes++;
                    totalCount++;
                }
                case 4 -> {
                    fours++;
                    totalCount++;
                }
                case 5 -> {
                    fives++;
                    totalCount++;
                }
                case 6 -> {
                    sixes++;
                    totalCount++;
                }
                case 7 -> {
                    sevens++;
                    totalCount++;
                }
                case 8 -> {
                    eights++;
                    totalCount++;
                }
                case 9 -> {
                    nines++;
                    totalCount++;
                }
                case 10 -> {
                    tens++;
                    totalCount++;
                }
            }
        }
        System.out.println("Twos Generated : " + twos);
        System.out.println("Observed Probabilty = "+ twos + " / " + totalCount + " = " + ((double)twos/totalCount));
        System.out.println("Threes Generated : " + threes);
        System.out.println("Observed Probabilty = "+ threes + " / " + totalCount + " = " + ((double)threes/totalCount));
        System.out.println("Fours Generated : "+ fours);
        System.out.println("Observed Probabilty = "+ fours + " / " + totalCount + " = " + ((double)fours/totalCount));
        System.out.println("Fives Generated : " + fives);
        System.out.println("Observed Probabilty = "+ fives + " / " + totalCount + " = " + ((double)fives/totalCount));
        System.out.println("Sixes Generated : " + sixes);
        System.out.println("Observed Probabilty = "+ sixes + " / " + totalCount + " = " + ((double)sixes/totalCount));
        System.out.println("Sevens Generated : " + sevens);
        System.out.println("Observed Probabilty = "+ sevens + " / " + totalCount + " = " + ((double)sevens/totalCount));
        System.out.println("Eights Generated : "+ eights);
        System.out.println("Observed Probabilty = "+ eights + " / " + totalCount + " = " + ((double)eights/totalCount));
        System.out.println("Nines Generated : " + nines);
        System.out.println("Observed Probabilty = "+ nines + " / " + totalCount + " = " + ((double)nines/totalCount));
        System.out.println("Tens Generated : " + tens);
        System.out.println("Observed Probabilty = "+ tens + " / " + totalCount + " = " + ((double)tens/totalCount));
        System.out.println(((double)twos/totalCount) + " + " + ((double)threes/totalCount) + " + " +((double)fours/totalCount) + " + " +((double)fives/totalCount) + " + "+ ((double)sixes/totalCount) + " + " + ((double)sevens/totalCount) + " + " +((double)sevens/totalCount) + " + " +((double)eights/totalCount) + " + " +((double)nines/totalCount) + " + " +((double)tens/totalCount) + " = " + (((double)twos/totalCount) + ((double)threes/totalCount) +((double)fours/totalCount) +((double)fives/totalCount) +((double)sixes/totalCount) + ((double)sevens/totalCount) +((double)eights/totalCount) +((double)nines/totalCount)+ ((double)tens/totalCount) ));

    }

}