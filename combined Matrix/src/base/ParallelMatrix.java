
package base;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Manuel
 *
 */
public class ParallelMatrix extends Matrix {
    /* (non-Javadoc)
     * @see base.Matrix#multiply(base.Matrix)
     */

    /**
     * Constructor parametrizado
     *
     * @param rDimension
     * @param cDimension
     */

    public ParallelMatrix(int rDimension, int cDimension) {

        super(rDimension, cDimension);
    }

    public ParallelMatrix(int rDimension, int cDimension, double[][] MatrizResult) {
        super(rDimension, cDimension, MatrizResult);
    }

    private static void waitForThreads(List<Thread> hilos)
    {
    	for(Thread hilo : hilos)
    	{
    		try
    		{
    			hilo.join();
    		}
    		catch(InterruptedException e)
    		{
    			e.printStackTrace();
    		}
    	}
    	hilos.clear();
    }


    @Override
    public double[][] multiply(Matrix secondMatrix) {
        long startTime = System.currentTimeMillis();
        double[][] matriz1 = matrixData;
        double[][] matriz2 = secondMatrix.matrixData;
        double[][] resultMatrix = new double[this.columnDimension][secondMatrix.getRowDimension()];
        List<Thread> task = new ArrayList<Thread>();

        for(int i = 0; i < this.getRowDimension(); i++)
        {
        	MultiplierThread hilo = new MultiplierThread(this.getRowVector(i), secondMatrix, resultMatrix[i]);
        	task.add(hilo);
        	hilo.start();
        	if(task.size()%rowDimension == 0)
        	{
        		waitForThreads(task);
        	}
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Tiempo de Multiplicación: " + (endTime - startTime) + "ms");
        System.out.println();
        return resultMatrix;
    }

    @Override
    public double[][] InversaG() {
        long startTime = System.currentTimeMillis();
        int dimension = this.getColumnDimension();
        double[][] matrizInversa = new double [dimension][dimension];
        double[][] matriz = this.matrixData;
        
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

            InverseMatriz t = new InverseMatriz(dimension, matrizInversa, matriz, this);
            t.start();

                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

            long endTime = System.currentTimeMillis();
            System.out.println("Tiempo de Inversa: " + (endTime - startTime) + "ms");
        return matrizInversa;
    }
    
    public synchronized void haciendoCero(int dimension, double[][] matriz, double[][] inversa)
    {
    	for (int i = dimension - 2; i >= 0; i--)
        {
            for (int j = dimension - 1; j > i; j--)
            {
                for (int k = 0; k < dimension; k++)
                    inversa[i][k] -= matriz[i][j] * inversa[j][k];
                for (int k = 0; k < dimension; k++)
                    matriz[i][k] -= matriz[i][j] * matriz[j][k];
            }
        }
    }
}


