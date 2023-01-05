package ObjectOrientedDesign;
import java.io.*;

public class SortSottile {
    static int insertionCount ;
    static int BubbleCount ;
    static int ShellCount ;

    public static int getInsertionCount() {
        return insertionCount;
    }

    public static int getBubbleCount() {
        return BubbleCount;
    }

    public static int getShellCount() {
        return ShellCount;
    }

    public static void setInsertionCount(int insertionCount) {
        SortSottile.insertionCount = insertionCount;
    }

    public static void setBubbleCount(int bubbleCount) {
        BubbleCount = bubbleCount;
    }

    public static void setShellCount(int shellCount) {
        ShellCount = shellCount;
    }
    public static void incrementInsertionCount() {
        setInsertionCount(getInsertionCount()+1);
    }

    public static void incrementBubbleCount() {
        setBubbleCount(getBubbleCount()+1);
    }

    public static void incrementShellCount() {
        ShellCount = ShellCount++;
    }

    public static void main(String[] args) throws IOException {
        int[] listToBeSorted = new int[1];
        //Makes all dah list
        // Runs loop and sorts each list prints counter
        // makes Counter zero
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter("test.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        myWriter.write("Insertion Sort Lists Sizes 1-1000: Lowest to Highest \n");
        for(int x = 1; x <= 1000; x++) {
            listToBeSorted = new int[x];
            for(int a = 0; a < x ; a++) {
                listToBeSorted[a] = (int) (Math.random() * 2147483647);
            }
            setInsertionCount(0);
            insertionSortLToG(listToBeSorted, listToBeSorted.length);
            /*for (int i = 0; i < listToBeSorted.length; i++) {
                System.out.println(listToBeSorted[i]);
            }*/
            myWriter.write((Integer.toString(listToBeSorted.length)));
            myWriter.write(",");
            myWriter.write(Integer.toString(getInsertionCount()));
            myWriter.write("\n");
        }
        myWriter.write("\n");
        setInsertionCount(0);
        myWriter.write("Insertion Lists Size 1000: Lowest of Highest \n");
        listToBeSorted = new int[1000];
        for(int a = 0; a < 1000 ; a++) {
            listToBeSorted[a] = (int) (Math.random() * 2147483647);
        }
        setInsertionCount(0);
        insertionSortLToG(listToBeSorted, listToBeSorted.length);
            /*for (int i = 0; i < listToBeSorted.length; i++) {
                System.out.println(listToBeSorted[i]);
            }*/
        myWriter.write(Integer.toString(listToBeSorted.length));
        myWriter.write(",");
        myWriter.write(Integer.toString(getInsertionCount()));
        myWriter.write("\n");

        myWriter.write("\n");
        setInsertionCount(0);
        myWriter.write("Insertion Lists Size 1000: Highest to Lowest \n");
        listToBeSorted = new int[1000];
            for(int a = 0; a < 1000 ; a++) {
                listToBeSorted[a] = (int) (Math.random() * 2147483647);
            }
            setInsertionCount(0);
            insertionSortGToL(listToBeSorted, listToBeSorted.length);
            /*for (int i = 0; i < listToBeSorted.length; i++) {
                System.out.println(listToBeSorted[i]);
            }*/
            myWriter.write(Integer.toString(listToBeSorted.length));
            myWriter.write(",");
            myWriter.write(Integer.toString(getInsertionCount()));
            myWriter.write("\n");

        myWriter.write("\n");
        setInsertionCount(0);
        myWriter.write("Bubble Sort Lists Sizes 1-1000: Lowest to Highest \n");
        /*insertionSortGToL(listToBeSorted, listToBeSorted.length);
        for (int i = 0; i < listToBeSorted.length; i++){
            System.out.println(listToBeSorted[i]);
        }
        System.out.println("");
        System.out.println(getInsertionCount());
        System.out.println("");*/
        for(int x = 1; x <= 1000; x++) {
            listToBeSorted = new int[x];
            for(int a = 0; a < x ; a++) {
                listToBeSorted[a] = (int) (Math.random() * 2147483647);
            }
            setBubbleCount(0);
            bubbleSortLToG(listToBeSorted, listToBeSorted.length);
            /*for (int i = 0; i < listToBeSorted.length; i++) {
                System.out.println(listToBeSorted[i]);
            }*/
            myWriter.write(Integer.toString(listToBeSorted.length));
            myWriter.write(",");
            myWriter.write(Integer.toString(getBubbleCount()));
            myWriter.write("\n");
        }
        myWriter.write("\n");
        myWriter.write("Bubble Lists Size 1000: Lowest and Highest\n");
        listToBeSorted = new int[1000];
        for(int a = 0; a < 1000 ; a++) {
            listToBeSorted[a] = (int) (Math.random() * 2147483647);
        }
        setBubbleCount(0);
        bubbleSortLToG(listToBeSorted, listToBeSorted.length);
            /*for (int i = 0; i < listToBeSorted.length; i++) {
                System.out.println(listToBeSorted[i]);
            }*/
        myWriter.write(Integer.toString(listToBeSorted.length));
        myWriter.write(",");
        myWriter.write(Integer.toString(getBubbleCount()));
        myWriter.write("\n");
        myWriter.write("Bubble Lists Size 1000: Highest to Lowest\n");
            listToBeSorted = new int[1000];
            for(int a = 0; a < 1000 ; a++) {
                listToBeSorted[a] = (int) (Math.random() * 2147483647);
            }
            setBubbleCount(0);
            bubbleSortGToL(listToBeSorted, listToBeSorted.length);
            /*for (int i = 0; i < listToBeSorted.length; i++) {
                System.out.println(listToBeSorted[i]);
            }*/
            myWriter.write(Integer.toString(listToBeSorted.length));
            myWriter.write(",");
            myWriter.write(Integer.toString(getBubbleCount()));
            myWriter.write("\n");

        myWriter.write("\n");
        int shellSortSize;

        myWriter.write("Shell Sort Lists of Size Powers of 2 (1 to 10) : Lowest to Highest\n");
        for(int x = 0; x <= 10; x++) {
            shellSortSize = (int) Math.pow(2, x);
            listToBeSorted = new int[shellSortSize];
            for(int a = 0; a < shellSortSize ; a++) {
                listToBeSorted[a] = (int) (Math.random() * 2147483647);
            }
            setInsertionCount(0);
            shellSortLToG(listToBeSorted, listToBeSorted.length);
    /*        for (int i = 0; i < listToBeSorted.length; i++) {
                System.out.println(listToBeSorted[i]);
            }*/
            myWriter.write(Integer.toString(listToBeSorted.length));
            myWriter.write(",");
            myWriter.write(Integer.toString(getInsertionCount()));
            myWriter.write("\n");
        }
        myWriter.write("\n");

        myWriter.write("Shell Sort List Size Powers of 2 (1 to 10): Highest to Lowest\n");
        for(int x = 0; x <= 10; x++) {
            shellSortSize = (int) Math.pow(2, x);
            listToBeSorted = new int[shellSortSize];
            for(int a = 0; a < shellSortSize ; a++) {
                listToBeSorted[a] = (int) (Math.random() * 2147483647);
            }
            setInsertionCount(0);
            shellSortGToL(listToBeSorted, listToBeSorted.length);
            /*for (int i = 0; i < listToBeSorted.length; i++) {
                System.out.println(listToBeSorted[i]);
            }*/
            myWriter.write(Integer.toString(listToBeSorted.length));
            myWriter.write(",");
            myWriter.write(Integer.toString(getInsertionCount()));
            myWriter.write("\n");
        }
        myWriter.write("\n");
        myWriter.close();







   }
    public static void insertionSortLToG(int[] listToBeSorted, int size){

        int newElement;
        int location;
        for (int i = 1; i < size; i++ ){
            newElement = listToBeSorted[i];
            location = i - 1;
            incrementInsertionCount();
            while ((location >= 0)&& (listToBeSorted[location] > newElement)){
                listToBeSorted[location + 1] = listToBeSorted[location];
                location = location - 1;
                incrementInsertionCount();
            }
            listToBeSorted[location + 1] = newElement;
        }
        //Book Psudo Code
        /*InsertionSort( list, N )
        list the elements to be put into order
        N the number of elements in the list
        for i = 1 to N do
            newElement = list[ i ]
        location = i - 1
        while (location ≥ 0) and (list[ location ] > newElement) do
            // move any larger elements out of the way
            list[ location + 1] = list[ location ]
        location = location - 1
        end while
        list[ location + 1 ] = newElement
        end for
        This algorithm copies the next value to b*/
    }
    public static void insertionSortGToL(int[] listToBeSorted , int size){
        int newElement;
        int location;
        for (int i = 1; i < size; i++ ){
            newElement = listToBeSorted[i];
            location = i - 1;
            incrementInsertionCount();
            while ((location >= 0)&& (listToBeSorted[location] < newElement)){
                listToBeSorted[location + 1] = listToBeSorted[location];
                location = location - 1;
                incrementInsertionCount();
            }
            listToBeSorted[location + 1] = newElement;
        }
    }
    public static void bubbleSortLToG(int[] listToBeSorted, int size){
        int numberOfPairs = size;
        int temp;
        boolean swappedElements = true;
        while (swappedElements){
            numberOfPairs = numberOfPairs - 1;
            swappedElements = false;
            for (int i = 0; i < numberOfPairs; i++){
                incrementBubbleCount();
                if(listToBeSorted[i] > listToBeSorted[i + 1]){
                    temp = listToBeSorted[i];
                    listToBeSorted[i] = listToBeSorted[i +1];
                    listToBeSorted[i + 1] = temp;
                    swappedElements = true;
                }
            }
        }
        //BubbleSort( list, N )
        //list the elements to be put into order
        //N the number of elements in the list
        //numberOfPairs = N
        //swappedElements = true
        //while swappedElements do
        // numberOfPairs = numberOfPairs - 1
        // swappedElements = false
        // for i = 1 to numberOfPairs do
        // if list[ i ] > list[ i + 1 ] then
        // Swap( list[i], list[i + 1] )
        // swappedElements = true
        // end if
        // end for
        //end while

    }
    public static void bubbleSortGToL(int[] listToBeSorted, int size){
        int numberOfPairs = size;
        int temp;
        boolean swappedElements = true;

        while (swappedElements){
            numberOfPairs = numberOfPairs - 1;
            swappedElements = false;
            for (int i = 0; i < numberOfPairs; i++){
                incrementBubbleCount();
                if(listToBeSorted[i] < listToBeSorted[i + 1]){
                    temp = listToBeSorted[i];
                    listToBeSorted[i] = listToBeSorted[i +1];
                    listToBeSorted[i + 1] = temp;
                    swappedElements = true;
                }
            }
        }
    }
    public static void shellSortLToG(int[] listToBeSorted, int size){
        int passes = (int) Math.floor(Math.log10(size)/Math.log10(2));
        int increment;
        while (passes >= 0){
            increment = (int) Math.pow(2 , (passes - 1));
            for (int start = 0; start < increment; start++){
                insertionSortLtoGForShell(listToBeSorted, size,start,increment);
            }
            passes = passes -1;
        }


        /*Shellsort( list, N )
        list the elements to be put into order
        N the number of elements in the list
        passes = lg N
        while (passes ≥ 1) do
            increment = 2passes - 1
        for start = 1 to increment do
            InsertionSort( list, N, start, increment )
        end for
        passes = passes - 1
        end while*/


    }

    private static void insertionSortLtoGForShell(int[] listToBeSorted, int size, int start, int increment) {
        int[] sublist = new int[((int)size/increment)];
        //get index of sorted numbers
        int sublistCounter = 0;
        /*Implement the Shell Sort algorithm based on the pseudo code given on page 91 of the text book.
        Instrument the code with comparison counters placed inside the Insertion Sort function (which is called
        from Shell Sort) just before the inner while loop and at the end of the body (within) the inner while loop.
                Run the code in a Monte Carlo fashion on list sizes of 2
        𝑁 𝑓𝑜𝑟 0 ≤ 𝑁 ≤ 10, recording the comparison
        counts for each size. The initial data should be uniformly random values. Plot the comparison counts
        using Excel or some other graphing tool.*/

        for(int i = start; i < size; i = i + increment){

            sublist[sublistCounter] = listToBeSorted[i];
            sublistCounter++;
        }
        insertionSortLToG(sublist, sublistCounter);
        sublistCounter = 0;
        for (int i = start; i < size; i = i + increment){
            listToBeSorted[i] = sublist[sublistCounter];
            sublistCounter++;
        }



    }
    public static void shellSortGToL(int[] listToBeSorted, int size){
        int passes = (int) Math.floor(Math.log10(size)/Math.log10(2));
        int increment;
        while (passes >= 0){
            increment = (int) Math.pow(2 , (passes - 1));
            for (int start = 0; start < increment; start++){
                insertionSortGtoLForShell(listToBeSorted, size,start,increment);
            }
            passes = passes -1;
        }
    }

    private static void insertionSortGtoLForShell(int[] listToBeSorted, int size, int start, int increment) {
        int[] sublist = new int[((int)size/increment)];
        //get index of sorted numbers
        int sublistCounter = 0;
        for(int i = start; i < size; i = i + increment){

            sublist[sublistCounter] = listToBeSorted[i];
            sublistCounter++;
        }
        insertionSortGToL(sublist, sublistCounter);
        sublistCounter = 0;
        for (int i = start; i < size; i = i + increment){
            listToBeSorted[i] = sublist[sublistCounter];
            sublistCounter++;
        }



    }
}
