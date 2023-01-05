package ObjectOrientedDesign;
import java.util.Scanner;
public class Problem_4 {
    public static void main(String[] args) throws Exception {
        int i =0;
        /*D1- 1,2,3,9,10,11
        D2 – 0,1,7,8,8,9
        D3 – 5,5,6,6,7,7
        D4 – 3,4,4,5,11,12*/
        int amountOfNums = 0;
        String dice1 = "";
        String dice2 = "";
        String[] diceList = {"d1","d2","d3","d4"};
        String[] diceList2 = {"d1","d2","d3","d4"};
        int[] d1 = {1,2,3,9,10,11};
        int[] d2 = {0,1,7,8,8,9};
        int[] d3 = {5,5,6,6,7,7};
        int[] d4 = {3,4,4,5,11,12};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number of Dice Duels to be simulated for all dice pairings");
        amountOfNums = scanner.nextInt();
        simulation newSim;
        int count = 1;
            try {
                for (String dice : diceList){
                    for (String dicE: diceList2){
                        if (dice.equals(dicE)){
                            System.out.print(" N/A      ");
                            count++;
                        }
                        if((dice.equals("d1")) && (dicE.equals("d2"))){
                            newSim = new simulation(d1,d2);
                            System.out.print(" " + newSim.runSimultion(amountOfNums) + " ");
                        }else if((dice.equals("d1")) && (dicE.equals("d3"))){
                            newSim = new simulation(d1,d3);
                            System.out.print(" " + newSim.runSimultion(amountOfNums) + " ");
                        }else if((dice.equals("d1")) && (dicE.equals("d4"))){
                            newSim = new simulation(d1,d4);
                            System.out.print(" " + newSim.runSimultion(amountOfNums) + " \n");
                        }else if((dice.equals("d2")) && (dicE.equals("d1"))) {
                            newSim = new simulation(d2, d1);
                            System.out.print(" " + newSim.runSimultion(amountOfNums) + " ");
                        }else if((dice.equals("d2")) && (dicE.equals("d3"))){
                            newSim = new simulation(d2,d3);
                            System.out.print(" " + newSim.runSimultion(amountOfNums) + " ");
                        }else if((dice.equals("d2")) && (dicE.equals("d4"))){
                            newSim = new simulation(d2,d4);
                            System.out.print(" " + newSim.runSimultion(amountOfNums) + " \n");
                        }else if((dice.equals("d3")) && (dicE.equals("d1"))) {
                            newSim = new simulation(d3, d1);
                            System.out.print(" " + newSim.runSimultion(amountOfNums) + " ");
                        }else if((dice.equals("d3")) && (dicE.equals("d2"))){
                            newSim = new simulation(d3,d2);
                            System.out.print(" " + newSim.runSimultion(amountOfNums) + " ");
                        }else if((dice.equals("d3")) && (dicE.equals("d4"))){
                            newSim = new simulation(d3,d4);
                            System.out.print(" " + newSim.runSimultion(amountOfNums) + " \n");
                        }else if((dice.equals("d4")) && (dicE.equals("d1"))) {
                            newSim = new simulation(d4, d1);
                            System.out.print(" " + newSim.runSimultion(amountOfNums) + " ");
                        }else if((dice.equals("d4")) && (dicE.equals("d2"))){
                            newSim = new simulation(d4,d2);
                            System.out.print(" " + newSim.runSimultion(amountOfNums) + " ");
                        }else if((dice.equals("d4")) && (dicE.equals("d3"))){
                            newSim = new simulation(d4,d3);
                            System.out.print(" " + newSim.runSimultion(amountOfNums) + " ");
                        }else{

                        }





                    }
                }




            } catch (Exception e) {
                throw new Exception(e);

            }


        /*DiceDuels[] outcomeList = new DiceDuels[36];
        for (int x = 0; x < 36; x++){
            outcomeList[x] = new DiceDuels(x);
        }

        for (int stupid: stupidStrings){
            for (int reallyStupid: reallyStupidStrings){
                outcomeList[i].setV1(stupid);
                outcomeList[i].setV2(reallyStupid);
                i++;
            }
        }
        for (DiceDuels duel: outcomeList){
            System.out.println(duel.toString());
        }*/


    }
    static class simulation{
        int[] stupidStrings;
        int[] reallyStupidStrings;
        int diceOneValueFaceOne = -1;
        int diceOneValueFaceTwo = -1;
        int diceOneValueFaceThree = -1;
        int diceOneValueFaceFour = -1;
        int diceOneValueFaceFive = -1;
        int diceOneValueFaceSix = -1;
        int diceTwoValueFaceOne = -1;
        int diceTwoValueFaceTwo = -1;
        int diceTwoValueFaceThree = -1;
        int diceTwoValueFaceFour = -1;
        int diceTwoValueFaceFive = -1;
        int diceTwoValueFaceSix = -1;


//        DiceDuels[] outcomeList = new DiceDuels[36];

        simulation(int[] stupider, int[] veryStupid){
            stupidStrings = stupider;
            reallyStupidStrings = veryStupid;


        }
        public double runSimultion(int reps){
            int wins = 0;
            int totalDuels = 0;
            for (int i = 0; i < 6; i++){
               if (i == 0){
                   setDiceOneValueFaceOne(stupidStrings[i]);
                   setDiceTwoValueFaceOne(reallyStupidStrings[i]);
               }else if(i == 1){
                   setDiceOneValueFaceTwo(stupidStrings[i]);
                   setDiceTwoValueFaceTwo(reallyStupidStrings[i]);
               }else if(i == 2){
                   setDiceOneValueFaceThree(stupidStrings[i]);
                   setDiceTwoValueFaceThree(reallyStupidStrings[i]);
               }else if(i == 3){
                   setDiceOneValueFaceFour(stupidStrings[i]);
                   setDiceTwoValueFaceFour(reallyStupidStrings[i]);
               }else if(i == 4){
                   setDiceOneValueFaceFive(stupidStrings[i]);
                   setDiceTwoValueFaceFive(reallyStupidStrings[i]);
               }else {
                   setDiceOneValueFaceSix(stupidStrings[i]);
                   setDiceTwoValueFaceSix(reallyStupidStrings[i]);
               }
            }
            for (int i = 0; i < reps; i++) {
                int rN1 = (int) (Math.random() * 6) + 1;
                int rN2 = (int) (Math.random() * 6) + 1;
                if (getTrueValueD1(rN1) > getTrueValueD2(rN2)) {
                    wins++;
                    totalDuels++;
                } else {
                    totalDuels++;
                }
            }
                return (double)wins/totalDuels;





        }
        public int getTrueValueD1(int rN){
            switch (rN){
                case 1:
                    return getDiceOneValueFaceOne();
                case 2:
                    return getDiceOneValueFaceTwo();
                case 3:
                    return getDiceOneValueFaceThree();
                case 4:
                    return getDiceOneValueFaceFour();
                case 5:
                    return getDiceOneValueFaceFive();
                case 6:
                    return getDiceOneValueFaceSix();
                default:
                    return -1;
            }
        }
        public int getTrueValueD2(int rN){
            switch (rN){
                case 1:
                    return getDiceTwoValueFaceOne();
                case 2:
                    return getDiceTwoValueFaceTwo();
                case 3:
                    return getDiceTwoValueFaceThree();
                case 4:
                    return getDiceTwoValueFaceFour();
                case 5:
                    return getDiceTwoValueFaceFive();
                case 6:
                    return getDiceTwoValueFaceSix();
                default:
                    return -1;
            }
        }

        public int getDiceOneValueFaceFive() {
            return diceOneValueFaceFive;
        }

        public int getDiceOneValueFaceOne() {
            return diceOneValueFaceOne;
        }

        public int getDiceOneValueFaceFour() {
            return diceOneValueFaceFour;
        }

        public int getDiceOneValueFaceSix() {
            return diceOneValueFaceSix;
        }

        public int getDiceOneValueFaceThree() {
            return diceOneValueFaceThree;
        }

        public int getDiceTwoValueFaceFive() {
            return diceTwoValueFaceFive;
        }

        public int getDiceOneValueFaceTwo() {
            return diceOneValueFaceTwo;
        }

        public int getDiceTwoValueFaceFour() {
            return diceTwoValueFaceFour;
        }

        public int getDiceTwoValueFaceOne() {
            return diceTwoValueFaceOne;
        }

        public int getDiceTwoValueFaceSix() {
            return diceTwoValueFaceSix;
        }

        public int getDiceTwoValueFaceThree() {
            return diceTwoValueFaceThree;
        }

        public int getDiceTwoValueFaceTwo() {
            return diceTwoValueFaceTwo;
        }

        public void setDiceOneValueFaceFive(int diceOneValueFaceFive) {
            this.diceOneValueFaceFive = diceOneValueFaceFive;
        }

        public void setDiceOneValueFaceFour(int diceOneValueFaceFour) {
            this.diceOneValueFaceFour = diceOneValueFaceFour;
        }

        public void setDiceOneValueFaceOne(int diceOneValueFaceOne) {
            this.diceOneValueFaceOne = diceOneValueFaceOne;
        }

        public void setDiceOneValueFaceSix(int diceOneValueFaceSix) {
            this.diceOneValueFaceSix = diceOneValueFaceSix;
        }

        public void setDiceOneValueFaceThree(int diceOneValueFaceThree) {
            this.diceOneValueFaceThree = diceOneValueFaceThree;
        }

        public void setDiceOneValueFaceTwo(int diceOneValueFaceTwo) {
            this.diceOneValueFaceTwo = diceOneValueFaceTwo;
        }

        public void setDiceTwoValueFaceFive(int diceTwoValueFaceFive) {
            this.diceTwoValueFaceFive = diceTwoValueFaceFive;
        }

        public void setDiceTwoValueFaceFour(int diceTwoValueFaceFour) {
            this.diceTwoValueFaceFour = diceTwoValueFaceFour;
        }

        public void setDiceTwoValueFaceOne(int diceTwoValueFaceOne) {
            this.diceTwoValueFaceOne = diceTwoValueFaceOne;
        }

        public void setDiceTwoValueFaceSix(int diceTwoValueFaceSix) {
            this.diceTwoValueFaceSix = diceTwoValueFaceSix;
        }

        public void setDiceTwoValueFaceThree(int diceTwoValueFaceThree) {
            this.diceTwoValueFaceThree = diceTwoValueFaceThree;
        }

        public void setDiceTwoValueFaceTwo(int diceTwoValueFaceTwo) {
            this.diceTwoValueFaceTwo = diceTwoValueFaceTwo;
        }

        public void setReallyStupidStrings(int[] reallyStupidStrings) {
            this.reallyStupidStrings = reallyStupidStrings;
        }

        public void setStupidStrings(int[] stupidStrings) {
            this.stupidStrings = stupidStrings;
        }
    }
    class sixSidedDice{
        int nameOfDice ;
        int [] sides;
        sixSidedDice(int[] side , int name){
            sides = side;
            nameOfDice = name;
        }

        public int getNameOfDice() {
            return nameOfDice;
        }

        public int[] getSides() {
            return sides;
        }
    }

    static class DiceDuels {
        int v1;
        int v2;
        int outcomeNumber;
        DiceDuels(int x) {
            v1 = -1;
            v2 = -1;
            outcomeNumber = x +1;
        }

        DiceDuels(int value1, int value2) {
            v1 = value1;
            v2 = value2;
        }

        public int getOutcomeNumber() {
            return outcomeNumber;
        }

        public int getV1() {
            return v1;
        }

        public int getV2() {
            return v2;
        }

        public void setV1(int v1) {
            this.v1 = v1;
        }

        public void setV2(int v2) {
            this.v2 = v2;
        }

        public DiceDuels swap() {
            return new DiceDuels(v2, v1);
        }

        @Override
        public String toString() {

            if(v1 > v2){
                return  "Outcome # "+ this.getOutcomeNumber()+ " : D1 is greater \n"
                        + " D1 = " + v1  +
                        " D2 = "+ v2;
            }else if (v1 < v2){
                return  "Outcome # "+ this.getOutcomeNumber()+ " : D2 is greater \n"
                        + " D1 = " + v1  +
                        " D2 = "+ v2;
            }else {
                return "Outcome # "+ this.getOutcomeNumber()+ " : D1 equals D2 \n"
                        + " D1 = " + v1  +
                        " D2 = "+ v2;
            }

        }
    }
}