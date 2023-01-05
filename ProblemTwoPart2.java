package ObjectOrientedDesign;
import java.util.Scanner;

class ProblemTwoPartTwo {
    public static void main(String[] args) throws Exception {
        boolean appRunning = true;
        String response;
        int[] diceOneRolls;
        int[] diceTwoRolls;
        int amountOfNums;
        Scanner newSC = new Scanner(System.in);
 /*       int choice;
        //Code Modified from Part 1
        //Co
        System.out.println("Type 1 for Counting Numbers up");
        System.out.println("Type 2 for Mean and Standard Deviation and Mean Calculations");
        System.out.println("Type 3 for both");
        choice = newSC.nextInt();
*/        while (appRunning == true){
            try {

                System.out.println("Enter Number Dice Rolls 1 - 5 ");
                amountOfNums = newSC.nextInt();
            }catch (Exception e){
                throw new Exception(e);

            }
            diceOneRolls = new int[amountOfNums];
            diceTwoRolls = new int[amountOfNums];
            for (int i = 0; i < amountOfNums; i++){
                diceOneRolls[i] = (int)(Math.random()*5)+1;
                diceTwoRolls[i] = (int)(Math.random()*5)+1;

            }
            countAllNums(diceOneRolls,diceTwoRolls);
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


    private static void countAllNums(int[] diceOneRolls, int[] allnumbs) {
        int length = allnumbs.length;
        int number = 0;

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
        for (int i = 0; i < length; i++){
            number = (diceOneRolls[i] + allnumbs[i]);

            switch (number){
                case 2:
                    twos++;
                    totalCount++;
                    break;
                case 3:
                    threes++;
                    totalCount++;
                    break;
                case 4:
                    fours++;
                    totalCount++;
                    break;
                case 5:
                    fives++;
                    totalCount++;
                    break;
                case 6:
                    sixes++;
                    totalCount++;
                    break;
                case 7:
                    sevens++;
                    totalCount++;
                    break;
                case 8:
                    eights++;
                    totalCount++;
                    break;
                case 9:
                    nines++;
                    totalCount++;
                    break;
                case 10:
                    tens++;
                    totalCount++;
                    break;

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
        System.out.println(((double)twos/totalCount) + " + " + ((double)threes/totalCount) + " + " +((double)fours/totalCount) + " + " +((double)fives/totalCount) + " + " +((double)sixes/totalCount) + " + " + ((double)sevens/totalCount) + " + " +((double)sevens/totalCount) + " + " +((double)eights/totalCount) + " + " +((double)nines/totalCount) + " + " +((double)tens/totalCount) + " = " + (((double)twos/totalCount) + ((double)threes/totalCount) +((double)fours/totalCount) +((double)fives/totalCount) +((double)sixes/totalCount) + ((double)sevens/totalCount) +((double)eights/totalCount) +((double)nines/totalCount)+ ((double)tens/totalCount) ));

    }

}
