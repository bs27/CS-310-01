package ObjectOrientedDesign;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PolynomialFitting {
    public static void main(String[] args) throws IllegalArgumentException, IOException {
//        a. Read data points from the file
//        b. Generate Q and U matrices
//        c. Use Gauss-Jordan elimination to generate Q inverse (from Q)
//        d. Use Winograd’s method for matrix multiplication to get the desired coefficient
        // e. Use Horners to write the new stuff to a file
        int k;
        Scanner degreeReader = new Scanner(System.in);
        ;
        String line;
        String[] points;
        int coefficientNumber;
        while (true) {
            try {
                k = degreeReader.nextInt();
                break;
            } catch (Exception e) {
                System.out.println(e);
                degreeReader.nextLine();
            }
        }
        degreeReader.close();
        coefficientNumber = k + 1;
        File input = new File("C:\\Users\\bjsot\\Desktop\\Algorithims\\src\\ObjectOrientedDesign\\polynomial.csv");
        Scanner fileWithPoints = new Scanner(input);
        int numberOfDataPoints = Integer.parseInt(fileWithPoints.nextLine());
        double[] x = new double[numberOfDataPoints];
        double[] y = new double[numberOfDataPoints];
        for (int i = 0; i < numberOfDataPoints; i++) {
            line = fileWithPoints.nextLine();
            points = line.split(",");
            x[i] = Double.parseDouble(points[0]);
            y[i] = Double.parseDouble(points[1]);
        }
        fileWithPoints.close();
        double[][] matrixQ = new double[coefficientNumber][coefficientNumber];
        double[][] mQ;
        double[][] inverse;
        double[][] matrixU = new double[coefficientNumber][1];
        double[][] mU;
        mQ = generateQMatrix(matrixQ, x);
//        printmatrix(mQ);
        mU = generateUMatrix(matrixU, x, y);
//        printmatrix(mU);
        double[][] identityofMQ = generateIdentity(coefficientNumber);
        inverse = findInverseWithoutSolutions(mQ, identityofMQ);
//        printmatrix(inverse);
        //This is it
        double[][] solution = simplyMult(inverse, mU);/*  WinogradsMatrixMult(inverse, mU);*/
        printmatrix(solution);
        double[] betterY = new double[numberOfDataPoints];
        int i = 0;
        for (double point : x){
            betterY[i] = hornersMethod(point, new double[]{solution[0][0],solution[1][0],solution[2][0],solution[3][0]});
            i++;
    }
        File nd = new File("C:\\Users\\bjsot\\Desktop\\Algorithims\\src\\ObjectOrientedDesign\\PolynomialNewPoints.csv");
        FileWriter writer = new FileWriter(nd);
        i = 0;
        for (double point : x ){
            writer.write(point + (",") + betterY[i] + "\n");
            i++;
        }
        writer.close();



        //-15260575.50327   48298427.30040   730919.73292 -0.09165

       /* for (int i = 0; i < numberOfDataPoints; i++){
            System.out.println(x[i] +"   " + y[i]);
        }*/


    }
    private static double hornersMethod(double x, double[] coeffiecientList) {
        int n = 0;
        double result = coeffiecientList[n];
        for (int i = n + 1; i <= coeffiecientList.length - 1; i++){
            result = result * x;
            result = result + coeffiecientList[i];
        }
        return result;
    }

    private static double[][] simplyMult(double[][] g, double[][] h) {
        //edit until it does what it should
        double[][] results = new double[4][1];
        results [0][0] = ((g[0][0] * h[0][0]) + (g[0][1] * h[0][0]) + (g[0][2] * h[0][0]) + (g[0][3] * h[0][0]));
        results [1][0] = ((g[1][0] * h[1][0]) + (g[1][1] * h[1][0]) + (g[1][2] * h[1][0]) + (g[1][3] * h[1][0]));
        results [2][0] = ((g[2][0] * h[2][0]) + (g[2][1] * h[2][0]) + (g[2][2] * h[2][0]) + (g[2][3] * h[2][0]));
        results [3][0] = ((g[3][0] * h[3][0]) + (g[3][1] * h[3][0]) + (g[3][2] * h[3][0]) + (g[3][3] * h[3][0]));
       return results;
    }

    private static double[][] generateIdentity(int coefficientNumber) {
        double[][] identity = new double[coefficientNumber][coefficientNumber];
        for (int i = 0; i < coefficientNumber; i++){
            for(int j = 0; j < coefficientNumber; j++){
                if(i == j){
                    identity[i][j] = 1;
                }else {
                    identity[i][j] = 0;
                }
                    }}
        return identity;
    }

    private static double[][] generateUMatrix(double[][] matrixU, double[] x, double[] y) {
        double sum;
        for (int i = 0; i < matrixU.length; i++){
            for(int j = 0; j < matrixU[0].length; j++){
                sum = 0;
                for (double pointx : x){
                    for(double pointy : y){
                    sum += Math.pow(pointx, (i +j)) * pointy;
                }}
                matrixU[i][j] = sum;

            }
        }
        return matrixU;
    }

    private static double[][] generateQMatrix(double[][] matrixQ, double[] x) {
        double sum;
        for (int i = 0; i < matrixQ.length; i++){
            for(int j = 0; j < matrixQ[0].length; j++){
                sum = 0;
                for (double point : x){
                    sum += Math.pow(point, (i +j));
                }
                matrixQ[i][j] = sum;

            }
        }
        return matrixQ;
    }
    public static double[][] WinogradsMatrixMult(double[][] mat1, double[][] mat2) throws IllegalArgumentException, ArithmeticException
    {
        if(mat1.length != mat2[0].length)
        {
            throw new IllegalArgumentException("Matrices cannot be multiplied");
        }
        int a = mat1.length;
        int b = mat1[0].length;
        int c = mat2[0].length;
        double[][] result = new double[a][c];
        double[] rowFactors = new double[a];
        double[] columnFactors = new double[c];
        int d = b/2;
        //  <@  Calculate row factors
        for(int i = 0; i < a; i++)
        {
            rowFactors[i] = mat1[i][0] * mat1[i][1];
            for(int j = 1; j < d; j++)
            {
                rowFactors[i] += mat1[i][2*j] * mat1[i][2*j+1];
            }
        }
//        System.out.println(Arrays.toString(rowFactors));
        //  <@  Calculate column factors
        for(int i = 0; i < c; i++)
        {
            columnFactors[i] = mat2[0][i] * mat2[1][i];
            for(int j = 1; j < d; j++)
            {
                columnFactors[i] += mat2[2*j][i] * mat2[2*j+1][i];
            }
        }
//        System.out.println(Arrays.toString(columnFactors));
        //  <@  Calculate results
        for(int i = 0; i < rowFactors.length; i++)
        {
            for(int j = 0; j < columnFactors.length; j++)
            {
                result[i][j] = -rowFactors[i] - columnFactors[j];
                for(int k = 0; k < d; k++)
                {
                    result[i][j] += (mat1[i][2*k] + mat2[2*k+1][j]) * (mat1[i][2*k+1] + mat2[2*k][j]);
                }
            }
        }
        //  <@  Deal with odd numbered row-column
        if(2 * (b / 2) != b)
        {
            for(int i = 0; i < a; i++)
            {
                for(int j = 0; j < c; j++)
                {
                    result[i][j] += mat1[i][b-1] * mat2[b-1][j];
                }
            }
        }
        return result;
    }


    /*private static double[][] winogradsMethod(double[][] g, double[][] h) {
        //Check if columns of g and rows of h match
        if (g.length != h[0].length){
            throw new IllegalArgumentException("Invalid Multiplication");
        }
        // rows of g
        int a = g.length;
        //columns of g and rows of h
        int b = g[0].length;
        // columns of h
        int c = h[0].length;
        double[] rowFactor = new double[a];
        double[] columnFactor = new double[c];
        double[][] r = new double[a][c];
        int d = b/2;
        //keep +1 added -1 changed a, b,c changed for loop for results,
        //error in bottom for loop
        for(int i = 0; i < a; i++ ){
            rowFactor[i] = g[i][0] * g[i][1];
            for(int j = 1; j < d; j++){
                rowFactor[i] = rowFactor[i] + g[i][2*j] * g[i][2*j+1];
            }
        }
        for(int i = 0; i < c; i++ ){
            columnFactor[i] =  h[0][i] * h[1][i];
            for(int j = 1; j < d; j++){
                columnFactor[i] = columnFactor[i] + h[2*j][i] * h[2*j+1][i];
            }
        }
        for (int i = 0; i<rowFactor.length; i++){
            for (int j = 0; j<columnFactor.length; j++){
                r[i][j] = -rowFactor[i] - columnFactor[j];
                for (int k = 0; k<d; k++){
                    r[i][j] = r[i][j] + (g[i][2*k] + h[2*k+1][j]) * (g[i][2*k+1] + h[2*k][j]);
                }
            }
        }
        if(2 * (b/2) != b){
            for(int i = 0; i<a; i++){
                for (int j = 0; j<c; j++){
                    r[i][j] = r[i][j] + g[i][b-1] * h[b-1][j];
                }
            }
        }





        return r;
    }*/
    public static void printmatrix(double m[][]) {
        for (int i = 0; i < m.length; ++i) {
            for (int j = 0; j < m[i].length; ++j) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static double[][] findInverseWithoutSolutions(double[][] equations, double[][] inverse) {

        // -- make sure we have N equations and N unknowns (inputs)
        if (equations.length != equations[0].length) {
            throw new IllegalArgumentException("invalid matrix");
        }
        //checkForInvalids with Reinhard Code Additions


        int h = equations.length;

        int w = equations[0].length;

        // -- this will hold the results
        double solutions[][] = new double[h][w];
        double inverseSolution[][] = new double[h][w];

        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                solutions[i][j] = equations[i][j];

            }
        }
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < (w); ++j) {
                inverseSolution[i][j] = inverse[i][j];

            }
        }

        // -- perform the Gauss-Jordan elimination
        for (int i = 0; i < h; ++i) { // -- loop through all rows
            // -- make the coefficient at the diagonal (location [i][i]) equal to 1
            //    by either multiplication or division
            double pivot = solutions[i][i];
            double pivotcandidate = pivot;
            int j = i;
            int candidaterow = i;
            // -- look for a value in the ith column that is not 0
            while (j < h && Math.abs(pivotcandidate) < 0.000001) {
                pivotcandidate = solutions[j][i];
                candidaterow = j;
                ++j;
            }

            // -- there is no non-zero pivot value in this column
            if (Math.abs(pivotcandidate) < 0.000001) {
                throw new ArithmeticException("singular matrix");
            }

            // -- swap rows if necessary
            double temp;
            if (candidaterow != i) {
                for (int k = 0; k < w; ++k) {
                    if(k != (w-1)) {
                        temp = solutions[candidaterow][k];
                        solutions[candidaterow][k] = solutions[i][k];
                        solutions[i][k] = temp;
                        temp = inverseSolution[candidaterow][k];
                        inverseSolution[candidaterow][k] = inverseSolution[i][k];
                        inverseSolution[i][k] = temp;
                    }else {
                        temp = solutions[candidaterow][k];
                        solutions[candidaterow][k] = solutions[i][k];
                        solutions[i][k] = temp;
                        temp = inverseSolution[candidaterow][k];
                        inverseSolution[candidaterow][k] = inverseSolution[i][k];
                        inverseSolution[i][k] = temp;
                    }
                }
            }

            // -- force the pivot value to 1 by division
            for (int k = 0; k < w; ++k) {
                if(k != (w-1)) {
                    solutions[i][k] /= pivotcandidate;
                    inverseSolution[i][k] /= pivotcandidate;
                }else {
                    solutions[i][k] /= pivotcandidate;
                    inverseSolution[i][k] /= pivotcandidate;
                }
            }

            // -- set all values in this column (i) equal to 0 by
            //    subtracting multiples of row i
            for (int r = 0; r < h; ++r) {
                if (r == i) {
                    continue;
                }
                double factor = solutions[r][i];
                for (int c = 0; c < w; ++c) {
                    if(c != (w-1)) {
                        solutions[r][c] -= solutions[i][c] * factor;
                        inverseSolution[r][c] -= inverseSolution[i][c] * factor;
                    }else {
                        solutions[r][c] -= solutions[i][c] * factor;
                        inverseSolution[r][c] -= inverseSolution[i][c] * factor;

                    }



                }
            }
            // printmatrix(equations);
            // System.out.println();

        }

        // -- should have an identity matrix on the left
        //    and solution matrix (vector) on the right
        return inverseSolution;
    }


}
