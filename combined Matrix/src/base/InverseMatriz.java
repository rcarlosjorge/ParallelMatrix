package base;

public class InverseMatriz extends Thread {

    private int columnVector;
    private int dimension;
    private double[][] matrizInversa;
    private double[][] matriz;
    private ParallelMatrix paralela;

    public InverseMatriz(int dimension, double[][] matrizInversa, double[][] matriz, ParallelMatrix paralela) {
      this.dimension = dimension;
      this.matriz = matriz;
      this.matrizInversa = matrizInversa;
        this.paralela = paralela;
    }


    public int getColumnVector() {
        return columnVector;
    }

    public void setColumnVector(int columnVector) {
        this.columnVector = columnVector;
    }



    public void run()
    {   
    	paralela.haciendoCero(dimension, matriz, matrizInversa);
    }
}