package ObjectOrientedDesign;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Collections.*;
/*
Create a program to search a sorted list of integers using the Binary Search method. You must implement this as a recursive method.
Demonstrate the correctness using a list of size 16 containing the values 0-15 (in ascending order) and searching for each of the values.
Report the number of “guesses” for each searched value.
Implement the recursive FindKthLargest function given on page 75 of the textbook.
 Note that the function Partition() is not provided. You will need to design and implement your own version.
Demonstrate your program using this list of numbers (from the example on page 7

        [16, 7, 10, 1, 5, 11, 3, 8, 14, 4, 2, 12, 6, 13, 9, 15]
        searching for the 1st, 8th, and 16th largest values. Report the positions of each of the values.
*/

import java.util.Locale;

public class SearchAndSelectionSottile {
    public static void main(String[] args) {
//        ArrayList<Integer> john = new ArrayList<Integer>();
//        int[] valuesToBeSearchedFor = new int[]{1,3,5,7,9,11,13,15,17,19};
//        for(int i = 0; i < (int) (Math.random() * 50); i++ ){
//            john.add(i,(int)(Math.random()*20));
//        }
//        Collections.sort(john);
        int [] valuesToBeSearchedFor= new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int [] arrayToBeSearchedWithBinary= new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int [] arrayToBeSearchedWithKthLargest= new int[]{16, 7, 10, 1, 5, 11, 3, 8, 14, 4, 2, 12, 6, 13, 9, 15};
//        int [] arrayToBeSearchedWithKthLargest2 = new int[]{1,2,3,4,5,35,7,8,9,17,11,12,13,56,15,16,1002,34,56,35,68,23,15};
        int [] kthNumberArray = new int[]{1,8,16};

//        int [] arrayToBeSearchedWithBinary= new int[john.size()];
//        for(int i = 0; i < john.size(); i++ ){
//            arrayToBeSearchedWithBinary[i] = john.get(i);
//        }
        System.out.println("Binary Search Algorithim");
        System.out.println("_______________Results________________");
        for(int i : valuesToBeSearchedFor){
            System.out.println(binarySearchRecursion(i,arrayToBeSearchedWithBinary,0,(arrayToBeSearchedWithBinary.length) - 1, 0));
        }
        System.out.println("Kth Largest Selection Algorithim");
        System.out.println("_______________Results________________");
        for(int i : kthNumberArray){
            System.out.println("K = : " + i + " K Largest = " + kthLargestAlgorithim(i,arrayToBeSearchedWithKthLargest,0,(arrayToBeSearchedWithKthLargest.length) - 1));
        }

    }

    private static int kthLargestAlgorithim(int k, int[] arrayToBeSearchedWithKthLargest, int beginning, int end) {
        int middle;
        int filtervalueLocation;
        int kIndex = k-1;
        //Binary Search/sort kinda
        //If the last index is greater than the beginning
        // this is a trigger to ensure the list doesn't recusre into oblivion
        //Keep changing beginining is end in partion
        if(beginning <= end){
            middle = ((beginning + end)/2);
            //Partition reassigns referances for the new list and returns the current K -1
             filtervalueLocation = Partion(arrayToBeSearchedWithKthLargest, middle,beginning,end );
             //Add one to account for the fact filter value location is an 0 index. The Biggest value K 1 with be in the 0 postion
             if((filtervalueLocation) == kIndex){
                 return arrayToBeSearchedWithKthLargest[filtervalueLocation];
             }else if((filtervalueLocation) < kIndex) {
                 return kthLargestAlgorithim(k, arrayToBeSearchedWithKthLargest, filtervalueLocation + 1, end);
             }else {
                 return kthLargestAlgorithim(k, arrayToBeSearchedWithKthLargest, beginning, filtervalueLocation - 1);
             }

        }
        return -1;
    }

    private static int Partion(int[] arrayToBeSearchedWithKthLargest, int middle, int beginning, int end) {
        int filterValueIndex;
        int filterValue = arrayToBeSearchedWithKthLargest[middle];
        //Size of new array
        int size = ((end - beginning)+1);
        // Array sizes are safe because it can accept every thing but the filter value.
        int[] smallerHalf = new int[size -1];
        int[] largerHalf = new int[size -1];
        int smallerHalfCounter = 0;
        int largerHalfCounter = 0;
        for (int i = beginning; i <= end; i++){
            if(filterValue > arrayToBeSearchedWithKthLargest[i]){
                smallerHalf[smallerHalfCounter] = arrayToBeSearchedWithKthLargest[i];
                smallerHalfCounter++;
            }else if (filterValue < arrayToBeSearchedWithKthLargest[i]){
                largerHalf[largerHalfCounter] = arrayToBeSearchedWithKthLargest[i];
                largerHalfCounter++;
            }
        }
        int index = beginning;
        for(int i = 0; i < largerHalfCounter; i++){
            arrayToBeSearchedWithKthLargest[index] = largerHalf[i];
            index++;
        }
        arrayToBeSearchedWithKthLargest[index] = filterValue;
        filterValueIndex = index;
        index++;
        for(int i = 0; i < smallerHalfCounter; i++){
            arrayToBeSearchedWithKthLargest[index] = smallerHalf[i];
            index++;
        }
        return filterValueIndex;

    }
    //Interview dudes

    // looking forward
    public static String binarySearchRecursion(int target, int[] listToBeSearched , int beginningIndex , int endIndex,int recursiveCalls){
        int guesses = recursiveCalls + 1;
        //Midpoints
        if(beginningIndex > endIndex){
            // Once it checks 15 lower+Upper =30/2 =15 it checks if target is greater or less than the to
            // which it adds one and maxs out the conditional
            return "Not in List";
        }
        int middle = (beginningIndex + endIndex)/2;
        if(listToBeSearched[middle] < target) {
            return binarySearchRecursion(target, listToBeSearched, (middle + 1), endIndex,guesses);
        }else if(listToBeSearched[middle] > target) {
            return binarySearchRecursion(target, listToBeSearched , beginningIndex, (middle-1),guesses);
        }else if(listToBeSearched[middle] == target) {
            return ("Target : " + target + " Found at index : " + middle + " Guesses : " + guesses);
        }else {
            //Needed to appease the Compiler
            return "";
        }


    }
    }



