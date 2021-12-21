
package base;

public class MultiplierThread extends Thread {

    private double[] rowVector;
    private double[] columnVector;
    private double[] result;
    private Matrix matriz2;
    private double[] resultMatriz;
    private double[][] matriz1;
    private double[][] matriz3;
    private double row;

    /**
     * Constructor parametrizado
     *
     * @param rowVector
     */
    public MultiplierThread(double[] rowVector, Matrix matriz2, double[] result)
    {
        this.setRowVector(rowVector);
        this.setMatriz2(matriz2);
        this.setResult(result);
    }
    

    private void setResult(double[] result2) {
		this.result = result2;
		
	}


	private void setMatriz2(Matrix matriz22) {
		this.matriz2 = matriz22;
		
	}


	/*public MultiplierThread(double[][] resultMatriz, double[][] matrix1, double[][] matrix2, int row, Matrix A) {
        this.setResultMatriz(resultMatriz);
        this.matriz1 = matrix1;
        this.matriz2 = matrix2;
        this.row = row;
        this.claseMatriz = A;
    }


    public double getRowVector() {
        return rowVector;
    }*/

    public double[] getResultMatriz() {
        return resultMatriz;
    }

    public void setResultMatriz(double[] resultMatriz) {
        this.resultMatriz = resultMatriz;
    }

    public void setRowVector(double[] rowVector) {
        this.rowVector = rowVector;
    }

    public void setColumnVector(double[] columnVector) {
        this.columnVector = columnVector;
    }

    /**
     *
     */
    public void run()
    {
    	double suma;
    	for(int j = 0; j < matriz2.getColumnDimension(); j++)
        {
    		suma = 0;
            for(int k = 0; k < matriz2.getColumnDimension(); k++)
            {
                suma += this.rowVector[k] * matriz2.getEntry(k, j);
            }
            result[j] = suma;
        }
        }
    }