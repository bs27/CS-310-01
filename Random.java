package ObjectOrientedDesign;
import java.util.Scanner;

class Random {
    public static void main(String[] args) throws Exception {
        boolean appRunning = true;
        String response;
        int[] allnumbs;
        int amountOfNums;
        int choice;
        Scanner newSC = new Scanner(System.in);
        System.out.println("How would you like to test the randomness of the RNG?");
        System.out.println("Type 1 for Counting Numbers up");
        System.out.println("Type 2 for Mean and Standard Deviation and Mean Calculations");
        System.out.println("Type 3 for both");
        choice = newSC.nextInt();
        while (appRunning == true){
            try {

                System.out.println("Enter Number of Random Numbers 1 - 6 ");
                amountOfNums = newSC.nextInt();
            }catch (Exception e){
                throw new Exception(e);

            }
            allnumbs = new int[amountOfNums];
            for (int i = 0; i < amountOfNums; i++){
                allnumbs[i] = (int)(Math.random()*6)+1;

            }
            switch (choice) {
                case 1 -> countAllNums(allnumbs);
                case 2 -> getMeanAndSD(allnumbs);
                case 3 -> {
                    countAllNums(allnumbs);
                    getMeanAndSD(allnumbs);
                }
            }
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

    private static void getMeanAndSD(int[] allnumbs) {
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
    }


    private static void countAllNums(int[] allnumbs) {
        int length = allnumbs.length;
        int number = 0;
        int ones = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        int fives = 0;
        int sixes = 0;
        for (int i = 0; i < length; i++){
            number = allnumbs[i];
            switch (number){
                case 1:
                    ones++;
                    break;
                case 2:
                    twos++;
                    break;
                case 3:
                    threes++;
                    break;
                case 4:
                    fours++;
                    break;
                case 5:
                    fives++;
                    break;
                case 6:
                    sixes ++;
                    break;
            }
        }
        System.out.println("Ones Generated : " + ones);
        System.out.println("Twos Generated : " + twos);
        System.out.println("Threes Generated : " + threes);
        System.out.println("Fours Generated : "+ fours);
        System.out.println("Fives Generated : " + fives);
        System.out.println("Sixes Generated : " + sixes);
    }

}
