package base;

import base.Matrix;

public class SequentialMatrix extends Matrix
{


    public SequentialMatrix(int rDimension, int cDimension)
    {
        super(rDimension, cDimension);
        // TODO Auto-generated constructor stub
    }

    /**
     * Codificación de producto de matrices
     * */

    @Override
    public double[][] multiply(Matrix secondMatrix)
    {
        double[][] matrizProducto = new double[rowDimension][rowDimension];
        double tiempo1, tiempo2, total;

        tiempo1 = System.currentTimeMillis();
        for(int i = 0; i < rowDimension; i++)
        {
            for(int j = 0; j < rowDimension; j++)
            {
                double suma = 0;

                for(int k = 0; k < rowDimension; k++)
                {
                    suma += this.matrixData[i][k] * secondMatrix.matrixData[k][j];
                }
                matrizProducto[i][j] = suma;

            }

        }
        tiempo2 = System.currentTimeMillis();
        total = tiempo2 - tiempo1;
        System.out.println("Producto de la Matriz " + rowDimension + "x" + rowDimension + ": " + total + " mils");

        return matrizProducto;
    }

    /**Reducción Gaussiana*/
    @Override
    public double[][] InversaG()
    {
        double tiempo1, tiempo2, total;

        tiempo1 = System.currentTimeMillis();
        int dimension = this.getColumnDimension();
        double matrizInversa [][] = new double [dimension][dimension];
        int matriz [][] = this.matrixData;

        /**Llenamos la matriz de identidad*/
        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++)
                matrizInversa[i][j] = 0;

        for (int i = 0; i < dimension; i++)
            matrizInversa[i][i] = 1;


        for (int k = 0; k < dimension; k++)
        {
            for (int i = k; i < dimension; i++)
            {
                double valInv = 1.0 / matriz[i][k];
                for (int j = k; j < dimension; j++)
                    matriz[i][j] *= valInv;
                for (int j = 0; j < dimension; j++)
                    matrizInversa[i][j] *= valInv;
            }
            for (int i = k + 1; i < dimension; i++)
            {
                for (int j = k; j < dimension; j++)
                    matriz[i][j] -= matriz[k][j];
                for (int j = 0; j < dimension; j++)
                    matrizInversa[i][j] -= matrizInversa[k][j];
            }
        }

        for (int i = dimension - 2; i >= 0; i--)
        {
            for (int j = dimension - 1; j > i; j--)
            {
                for (int k = 0; k < dimension; k++)
                    matrizInversa[i][k] -= matriz[i][j] * matrizInversa[j][k];
                for (int k = 0; k < dimension; k++)
                    matriz[i][k] -= matriz[i][j] * matriz[j][k];
            }
        }
        tiempo2 = System.currentTimeMillis();
        total = tiempo2 - tiempo1;
        System.out.println("Inversa de la Matriz " + rowDimension + "x" + rowDimension + ": " + total + " Mils");

        return matrizInversa;
    }
}
