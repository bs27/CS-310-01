package ObjectOrientedDesign;

import java.io.IOException;
import java.util.Random;
import java.io.*;

public class MergeSortProgram {
    static int counter;
    public static void main(String[] args) throws IOException {
        // print counter and set to zero
        int[] listOfSizes = {10, 100, 1000, 10000, 100000, 1000000};


        int[] listToBeSorted;

                /*
        int[] listToBeSorted = new int[16];
        for (int a = 0; a < 16; a++) {
            listToBeSorted[a] = (int) (Math.random() * 100);
        }
        MergeSort(listToBeSorted, 0, (listToBeSorted.length - 1));
        for (int a = 0; a < 16; a++) {
            System.out.println(listToBeSorted[a]);
        }*/
        Random steve = new Random(272727);
        for(int value : listOfSizes){
            listToBeSorted = new int[value];
            for (int a = 0; a < value; a++) {
                listToBeSorted[a] = (steve.nextInt(100001));
            }
            MergeSort(listToBeSorted, 0, listToBeSorted.length - 1);
        /*for (int a = 0; a < x; a++) {
            System.out.println(listToBeSorted[a]);
        }*/
            System.out.print(value + "," + counter);
            System.out.print("\n");
            counter = 0;
        }


    }

    public static void MergeSort(int[] list, int first, int last) {
        int middle;
        if (first < last) {
            middle = (first + last) / 2;
            MergeSort(list, first, middle);
            MergeSort(list, (middle + 1), last);
            MergeLists(list, first, middle, middle + 1, last);
        }

    }

    public static void MergeLists(int[] list, int start1, int end1, int start2, int end2) {
        int finalStart = start1;
        int finalEnd = end2;
        int indexC = 0;
        int[] result = new int[list.length];
        //optimize^
        while ((start1 <= end1) && (start2 <= end2)) {
            counter++;
            if (list[start1] < list[start2]) {
                result[indexC] = list[start1];
                start1 = start1 + 1;
            } else {
                result[indexC] = list[start2];
                start2 = start2 + 1;
            }
            indexC++;
        }
        if (start1 <= end1) {
            for (int i = start1; i <= end1; i++) {
                result[indexC] = list[i];
                indexC = indexC + 1;
            }}else{
                for (int i = start2; i <= end2; i++) {
                    result[indexC] = list[i];
                    indexC = indexC + 1;
                }
            }
            indexC = 0;
            for (int i = finalStart; i <= finalEnd; i++) {
                list[i] = result[indexC];
                indexC = indexC + 1;

            }
        }
    }

