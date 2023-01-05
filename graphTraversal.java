package ObjectOrientedDesign;
import java.util.*;

public class graphTraversal {
    public static void main(String[] Args) {
        // All adjacency Matrixs-thanks Geet
        int[][] a = {
                {0, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 1, 1, 0, 1, 0, 0}
        };
        int[][] Matrix = {
                {0, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 1, 1, 0, 1, 0, 0}
        };;
        LinkedList<Integer>[] steven;
        steven = covertToAList(a);
        System.out.println("A: depthFirstTraversalAdacencyMatrix");
        depthFirstTraversalAdacencyMatrix(Matrix, 0);
        System.out.println("\n");
        System.out.println("A: breadthFirstTraversalAdajacencyMatrix");
        breadthFirstTraversalAdajacencyMatrix(a,0);
        System.out.println("\n");




        int[] beenTheirDoneThat = new int[a.length];
        for(int i = 0; i < a[0].length; i++){
            beenTheirDoneThat[i] = -1;
        }
        System.out.println("A: depthFirstTraversalAdacencyList");
        depthFirstTraversalAdacencyList(steven,0,beenTheirDoneThat);
        System.out.println("\n");
        for(int i = 0; i < a[0].length; i++){
            beenTheirDoneThat[i] = -1;
        }
       // System.out.println("Revolutionary");
        System.out.println("A: breadthFirstTraversalAdajacencyList");
        breadthFirstTraversalAdajacencyList(steven,0,beenTheirDoneThat);
        System.out.println("\n");



        int[][] b = {
                {0, 0, 0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 1, 0}
        };
        int[][] b2 = {
                {0, 0, 0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 1, 0}
        };

        steven = covertToAList(b);
        System.out.println("B: depthFirstTraversalAdacencyMatrix");
        depthFirstTraversalAdacencyMatrix(b, 0);
        System.out.println("\n");
        System.out.println("B: breadthFirstTraversalAdacencyMatrix");
        breadthFirstTraversalAdajacencyMatrix(b2,0);
        System.out.println("\n");
        for(int i = 0; i < b[0].length; i++){
            beenTheirDoneThat[i] = -1;
        }
        System.out.println("B: depthFirstTraversalAdacencyList");
        depthFirstTraversalAdacencyList(steven,0,beenTheirDoneThat);
        System.out.println("\n");
        for(int i = 0; i < b[0].length; i++){
            beenTheirDoneThat[i] = -1;
        }
        // System.out.println("Revolutionary");
        System.out.println("B: breadthFirstTraversalAdacencyList");
        breadthFirstTraversalAdajacencyList(steven,0,beenTheirDoneThat);
        System.out.println("\n");

        int[][] c = {
                {0, 1, 0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0}
        };
        int[][] c2 = {
                {0, 1, 0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0}
        };
        steven = covertToAList(c);
        System.out.println("C: DepthFirstTraversalAdacencyMatrix");
        depthFirstTraversalAdacencyMatrix(c, 0);
        System.out.println("\n");
        System.out.println("C: BreadthFirstTraversalAdacencyMatrix");
        breadthFirstTraversalAdajacencyMatrix(c2,0);
        System.out.println("\n");
        for(int i = 0; i < c[0].length; i++){
            beenTheirDoneThat[i] = -1;
        }
        System.out.println("C: DepthFirstTraversalAdacencyList");
        depthFirstTraversalAdacencyList(steven,0,beenTheirDoneThat);
        System.out.println("\n");
        for(int i = 0; i < c[0].length; i++){
            beenTheirDoneThat[i] = -1;
        }
        // System.out.println("Revolutionary");
        System.out.println("C: BreadthFirstTraversalAdacencyList");
        breadthFirstTraversalAdajacencyList(steven,0,beenTheirDoneThat);
        System.out.println("\n");

        int[][] d = {
                {0, 1, 0, 1, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 1, 1, 0, 0, 1, 1},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0}
        };
        int[][] d2 = {
                {0, 1, 0, 1, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 1, 1, 0, 0, 1, 1},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0}
        };
        steven = covertToAList(d);
        System.out.println("D: DepthFirstTraversalAdacencyMatrix");
        depthFirstTraversalAdacencyMatrix(d, 0);
        System.out.println("\n");
        System.out.println("D: BreadthFirstTraversalAdacencyMatrix");
        breadthFirstTraversalAdajacencyMatrix(d2,0);
        System.out.println("\n");
        for(int i = 0; i < d[0].length; i++){
            beenTheirDoneThat[i] = -1;
        }
        System.out.println("D: DepthFirstTraversalAdacencyList");
        depthFirstTraversalAdacencyList(steven,0,beenTheirDoneThat);
        System.out.println("\n");
        for(int i = 0; i < d[0].length; i++){
            beenTheirDoneThat[i] = -1;
        }
        // System.out.println("Revolutionary");
        System.out.println("D: BreadthFirstTraversalAdacencyList");
        breadthFirstTraversalAdajacencyList(steven,0,beenTheirDoneThat);
        System.out.println("\n");



    }

    private static void breadthFirstTraversalAdajacencyMatrix(int[][] Matrix, int v) {
        LinkedList<Integer> itenerary = new LinkedList<Integer>();
        visit(Matrix, v);
        Matrix = mark(Matrix, v);
        enqueue(itenerary,v);
        while (itenerary.size() != 0){
            int newV = dequeue(itenerary);
            for (int i = 0; i<Matrix.length; i++){
                if(Matrix[newV][i]!= 0){
                    visit(Matrix,i);
                    mark(Matrix,i);
                    enqueue(itenerary,i);

                }
            }
        }
    }
    private static void breadthFirstTraversalAdajacencyList(LinkedList<Integer>[] Matrix, int v, int[] seenIt) {
        LinkedList<Integer> itenerary = new LinkedList<Integer>();
        visitList(Matrix, v);
        markList(Matrix, v,seenIt);
        enqueue(itenerary,v);
        while (itenerary.size() != 0){
            int newV = dequeue(itenerary);
        for (int canidate : Matrix[newV]){
            boolean goodToGo = true;
            for( int seen : seenIt){
                if (canidate == seen){
                    goodToGo = false;
                }
            }
            if (goodToGo){
                visitList(Matrix, canidate);
                markList(Matrix, canidate,seenIt);
               enqueue(itenerary,canidate);
            }

        }}
    }
        /*LinkedList<Integer> itenerary = new LinkedList<Integer>();
        visit(Matrix, v);
        Matrix = mark(Matrix, v);
        enqueue(itenerary,v);
        while (itenerary.size() != 0){
            int newV = dequeue(itenerary);
            for (int i = 0; i<Matrix.length; i++){
                if(Matrix[newV][i]!= 0){
                    visit(Matrix,i);
                    mark(Matrix,i);
                    enqueue(itenerary,i);

                }
            }
        }
    }*/

    private static int dequeue(LinkedList<Integer> itenerary) {
        int newV = itenerary.getFirst();
        itenerary.removeFirst();
        return newV;
    }

    private static void enqueue(LinkedList<Integer> itenerary, int v) {
        itenerary.addLast(v);
    }

    private static void depthFirstTraversalAdacencyList(LinkedList<Integer>[] Matrix, int v, int[] seenIt) {
        visitList(Matrix, v);
        markList(Matrix, v,seenIt);
        for (int canidate : Matrix[v]){
            boolean goodToGo = true;
            for( int seen : seenIt){
                if (canidate == seen){
                    goodToGo = false;
                }
            }
            if (goodToGo){
                depthFirstTraversalAdacencyList(Matrix, canidate, seenIt);
            }

        }
    }

    private static void markList(LinkedList<Integer>[] Matrix, int v,int[] seenIt) {
        seenIt[v] = v;
    }

    private static void visitList(LinkedList<Integer>[] Matrix, int v) {
        System.out.println(v+1);
    }

    private static LinkedList<Integer>[] covertToAList(int[][] Matrix) {
        LinkedList<Integer>[] steven = new LinkedList[Matrix.length];
        for (int i = 0; i < Matrix[0].length; i++){
            steven[i] = new LinkedList<Integer>();
        }
        for(int i = 0; i < Matrix[0].length; i++){
            for(int j = 0; j < Matrix[0].length; j++){
                if (Matrix[i][j] != 0){
                    steven[i].add(j);
                }

            }
        }
        return steven;
    }


    public static void depthFirstTraversalAdacencyMatrix(int[][] Matrix, int v) {
        visit(Matrix, v);
        Matrix = mark(Matrix, v);
        for (int i = 0; i < Matrix[0].length; i++){
            if(Matrix[v][i] != 0){
                depthFirstTraversalAdacencyMatrix(Matrix, i );
            }
        }
    }

    private static void visit(int[][] Matrix, int v) {
        System.out.println(v+1);
    }

    private static int[][] mark(int[][] Matrix, int v) {
        for (int i = 0; i < Matrix.length; i++) {
            if(Matrix[i][v] != 0){
                Matrix[i][v] = 0;
            }
        }
        return Matrix;
    }

}


