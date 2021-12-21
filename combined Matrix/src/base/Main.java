package base;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    private static int rDimension;
    private static int cDimension;

    public static void main(String[] args) {
        int p = rDimension;
        int Z = cDimension;


        System.out.println("----------MULTIPLICACION DE MATRICES Secuenciales----------");

        Matrix A = new SequentialMatrix(400, 400);
        Matrix B = new SequentialMatrix(400, 400);

        A.multiply(B);
        A.InversaG();

        System.out.println();
        System.out.println("----------MULTIPLICACION DE MATRICES PARALELO----------");

        ParallelMatrix N = new ParallelMatrix(400,400);
        ParallelMatrix P = new ParallelMatrix(400,400);
        N.multiply(P);
        N.InversaG();
    }
}
