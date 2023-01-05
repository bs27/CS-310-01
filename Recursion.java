//A recursive algorithm consists of four primary parts
//        1.	The direct solution in which the recursion terminates
//        2.	The problem division in which the original problem is reduced to one or more “smaller” problems (approaching the case for the direct solution)
//        3.	The recurrence, the self referential call
//        4.	The recombination where the solutions to the “smaller” problems are combined into the final solution

package ObjectOrientedDesign;
import java.util.Scanner;
public class Recursion {
    public static void main(String[] args) {

        Scanner newSC = new Scanner(System.in);
        System.out.println("Enter N number of Fibonacci Numbers you like to find: ");
        int n = newSC.nextInt();
        System.out.println("Iterative Method to find + " + n);
        System.out.println("n = " + n + " -> " +FibonacciSeries(n));
        System.out.println("Recursive Method to find + " + n);
        System.out.println("n = " + n + " -> " +FibonacciRecursive(n));

    }
    public static int FibonacciSeries(int n){
        int a = 0;
        int b = 1;
        int newBValue = 0;
        if(n == 1) {
            return a;
        }else if(n == 2) {
            return 1;
        }else {
            for (int i = 3; i <= n; i++){
                newBValue = a + b;
                a = b;
                b = newBValue;
            }
            return newBValue;
        }

    }

    public static int FibonacciRecursive(int n){
        if(n == 1) {
            return 0; // 1.	The direct solution in which the recursion terminates
        }else if (n==2){
            return 1; // 1.	The direct solution in which the recursion terminates
        }else {
            return FibonacciRecursive(n - 1) + (FibonacciRecursive(n - 2));   // 3.	The recurrence, the self referential call
            // 2. The problem division in which the original problem is reduced to one or more “smaller” problems (approaching the case for the direct solution)
//        3.	The recurrence, the self referential call
//        4.	The recombination where the solutions to the “smaller” problems are combined into the final solution This happens on the stack
        }
    }
}

