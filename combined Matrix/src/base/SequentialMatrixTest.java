package base;

import static org.junit.jupiter.api.Assertions.*;

class SequentialMatrixTest {

    @org.junit.jupiter.api.Test
    void multiply() {
        double[][] matriz1 = {{3,4},{2,5}};
        double[][] matriz2 = {{4,3},{5,2}};
        double[][] ResultMatriz = {{32,17}, {33,16}};

        SequentialMatrix A = new SequentialMatrix(2, 2, matriz1);
        SequentialMatrix B = new SequentialMatrix(2, 2, matriz2);
        double[][] C =  A.multiply(B);

        assertArrayEquals(ResultMatriz, C);

    }


    @org.junit.jupiter.api.Test
    void inversaG() {
        double[][] matriz1 = {{3,4},{2,5}};
        double[][] matriz2 = {{4,3},{5,2}};
        double[][] ResultMatriz = {{32,17}, {33,16}};

        ParallelMatrix C = new ParallelMatrix(2, 2, matriz1);
        ParallelMatrix D = new ParallelMatrix(2, 2, matriz2);
        double[][] E =  C.multiply(D);

        assertArrayEquals(ResultMatriz, E);
    }
}