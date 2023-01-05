package ObjectOrientedDesign;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class QuickSortProgram {
    static int counter = 0;
    public static void main(String[] args) throws IOException {
        /*int[] listToBeSorted = new int[16];
        for (int a = 0; a < 16; a++) {
            listToBeSorted[a] = (int) (Math.random() * 100000);
        }
        for (int a = 0; a < 16; a++) {
            System.out.println(listToBeSorted[a]);
        }
        System.out.println("------------------");
        QuickSortRandom2(listToBeSorted, 0, (listToBeSorted.length - 1));
        for (int a = 0; a < 16; a++)
            System.out.println(listToBeSorted[a]);
*/
        /*FileWriter myWriter = null;
        int[] listToBeSorted;
        try {
            myWriter = new FileWriter("test.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        System.out.println("------Quick Sort Pivot Number First in List-------");
        System.out.println("Size   |   Compasrisions");
        int[] listToBeSorted;
        int[] listOfSizes = {10, 100, 1000, 10000, 100000, 1000000};

        java.util.Random steve = new Random(272727);
        for(int value : listOfSizes){
            listToBeSorted = new int[value];
            for (int a = 0; a < value; a++) {
                listToBeSorted[a] = (steve.nextInt(100001));
            }
            QuickSort(listToBeSorted, 0, listToBeSorted.length - 1);
        /*for (int a = 0; a < value; a++) {
            System.out.println(listToBeSorted[a]);
        }*/
            System.out.println(value + "    |   " + counter);
            counter = 0;
        }
        System.out.println("------Quick Sort Pivot Number Last in List-------");
        System.out.println("Size   |   Compasrisions");
        for(int value : listOfSizes){
            listToBeSorted = new int[value];
            for (int a = 0; a < value; a++) {
                listToBeSorted[a] = (steve.nextInt(100001));
            }
            QuickSortLastNum(listToBeSorted, 0, listToBeSorted.length - 1);
        /*for (int a = 0; a < value; a++) {
            System.out.println(listToBeSorted[a]);
        }*/
            System.out.println(value + "    |   " + counter);
            counter = 0;
        }
        System.out.println("------Quick Sort Pivot Number Random in List-------");
        System.out.println("Size   |   Compasrisions");
        for(int value : listOfSizes){
            listToBeSorted = new int[value];
            for (int a = 0; a < value; a++) {
                listToBeSorted[a] = (steve.nextInt(100001));
            }
            QuickSortRandom2(listToBeSorted, 0, listToBeSorted.length - 1);
        /*for (int a = 0; a < value; a++) {
            System.out.println(listToBeSorted[a]);
        }*/
            System.out.println(value + "    |   " + counter);
            counter = 0;
        }
        steve = null;
        listOfSizes = null;
        System.gc();
        listToBeSorted = new int[100001];
        System.out.println("------Quick Sort Best Case Analysis-------");
        System.out.println("Size   |   Compasrisions");
        for (int a = 0; a <= 100000; a++) {
            listToBeSorted[a] = a;
        }
        QuickSort(listToBeSorted, 0, listToBeSorted.length - 1);
        /*for (int a = 0; a < value; a++) {
            System.out.println(listToBeSorted[a]);
        }*/
        // 0, 100,000
        System.out.println(listToBeSorted.length + "    |   " + counter);
        counter = 0;
        listToBeSorted = new int[100001];
        System.out.println("------Quick Sort Worst Case Analysis-------");
        for (int a = 100000; a >= 0; a--) {
            listToBeSorted[(100000-a)] = a;
        }
        QuickSort(listToBeSorted, 0, listToBeSorted.length - 1);
        System.out.println("Size   |   Compasrisions");
        /*for (int a = 0; a < value; a++) {
            System.out.println(listToBeSorted[a]);
        }*/
        // 0, 100,000
        System.out.println(listToBeSorted.length + "    |   " + counter);
        counter = 0;

    }

        /*int[] listToBeSorted = new int[16];
        for (int a = 0; a < 16; a++) {
            listToBeSorted[a] = (int) (Math.random() * 1000);
        }
        for (int a = 0; a < 16; a++) {
            System.out.println(listToBeSorted[a]);
        }
        System.out.println("------------------");
        QuickSort(listToBeSorted, 0, (listToBeSorted.length - 1));
        for (int a = 0; a < 16; a++) {
            System.out.println(listToBeSorted[a]);
        }*/
        /*for (int x = 0; x <= 100000; x++) {
            listToBeSorted = new int[x];
            for (int a = 0; a < x; a++) {
                listToBeSorted[a] = (int) (Math.random() * 2147483647);
            }
            MergeSort(listToBeSorted , 0 , listToBeSorted.length-1);
            for (int a = 0; a < x; a++) {
                System.out.println(listToBeSorted[a]);
            }
            System.out.println("________________________________________________________________________________");
        }*/
        //myWriter.close();

   // }

    private static void QuickSort(int[] list, int first, int last) {
        if(first < last){
            int pivot = PivotList(list, first , last);
            QuickSort(list, first, pivot -1);
            QuickSort(list, pivot + 1, last);
        }


    }

    private static int PivotList(int[] list, int first, int last) {
        int pivotValue = list[first];
        int pivotPoint = first;
        for (int index = first + 1; index <= last; index++) {
            counter++;
            if (list[index] < pivotValue) {
                pivotPoint = pivotPoint + 1;
                //Swap
                int holder = list[pivotPoint];
                list[pivotPoint] = list[index];
                list[index] = holder;
            }
        }
            //Swap
            int holder = list[first];
            list[first] = list[pivotPoint];
            list[pivotPoint] = holder;
            return pivotPoint;

        //move pivot value into correct place


    }
    private static void QuickSortLastNum(int[] list, int first, int last) {
        //Run least to Greatest with pivot as the last number
        if(first < last){
            int pivot = PivotListLastNum(list, first , last);
            QuickSortLastNum(list, first, pivot -1);
            QuickSortLastNum(list, pivot + 1, last);
        }


    }

    private static int PivotListLastNum(int[] list, int first, int last) {
        //
        int pivotValue = list[last];
        int pivotPoint = first - 1 ;
        for (int index = first; index < last; index++) {
            counter++;
            if (list[index] < pivotValue) {
                pivotPoint = pivotPoint + 1;
                //Swap
                int holder = list[pivotPoint];
                list[pivotPoint] = list[index];
                list[index] = holder;
            }
        }
        //Swap
        int holder = list[last];
        list[last] = list[pivotPoint+1];
        list[pivotPoint+1] = holder;
        return pivotPoint+1;

        //move pivot value into correct place


    }
    private static void QuickSortLargestToSmallest(int[] list, int first, int last) {
        if(first < last){
            int pivot = PivotListLToS(list, first , last);
            QuickSortLargestToSmallest(list, first, pivot -1);
            QuickSortLargestToSmallest(list, pivot + 1, last);
        }


    }

    private static int PivotListLToS(int[] list, int first, int last) {
        int pivotValue = list[first];
        int pivotPoint = first;
        for (int index = first + 1; index <= last; index++) {
            counter++;
            if (list[index] > pivotValue) {
                pivotPoint = pivotPoint + 1;
                //Swap
                int holder = list[pivotPoint];
                list[pivotPoint] = list[index];
                list[index] = holder;
            }
        }
        //Swap
        int holder = list[first];
        list[first] = list[pivotPoint];
        list[pivotPoint] = holder;
        return pivotPoint;

        //move pivot value into correct place


    }

        //move pivot value into correct place
        private static void QuickSortRandom2(int[] list, int first, int last) {
            //Run least to Greatest with pivot as the last number
            if(first < last){
                int pivot = PivotListRandom2(list, first , last);
                QuickSortRandom2(list, first, pivot - 1);
                QuickSortRandom2(list, pivot + 1, last);
            }


        }

    private static int PivotListRandom2(int[] list, int first, int last) {
        int pivotindex = (int) ((Math.random() * (last - first))+first);
        int holder2;
        holder2 = list[first];
        list[first] = list[pivotindex];
        list[pivotindex] = holder2;
        int pivotValue = list[first];
        int pivotPoint = first;
        for (int index = first + 1; index <= last; index++) {
            counter++;
            if (list[index] < pivotValue) {
                pivotPoint = pivotPoint + 1;
                //Swap
                int holder = list[pivotPoint];
                list[pivotPoint] = list[index];
                list[index] = holder;
            }
        }
        //Swap
        int holder = list[first];
        list[first] = list[pivotPoint];
        list[pivotPoint] = holder;
        return pivotPoint;

        //move pivot value into correct place


    }
    // Java program to illustrate


    }
