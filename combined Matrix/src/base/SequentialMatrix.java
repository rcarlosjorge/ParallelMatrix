package base;

public class SequentialMatrix extends Matrix {

    public SequentialMatrix(int rDimension, int cDimension) {
        super(rDimension, cDimension);
    }
    public SequentialMatrix(int rDimension, int cDimension, double[][] MatrizResult) {
        super(rDimension, cDimension, MatrizResult);
    }

    @Override
    public double[][] multiply(Matrix secondMatrix) {
        long startTime = System.currentTimeMillis();
        double[][] resultMatrix = new double[this.columnDimension][secondMatrix.getRowDimension()];
        double[][] matriz1 = matrixData;
        double[][] matriz2 = secondMatrix.matrixData;

        for(int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz2[0].length; j++) {
                for (int k = 0; k < matriz1[0].length; k++) {
                    resultMatrix[i][j] = resultMatrix[i][j] + matriz1[i][k] * matriz2[k][j];
                }
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println ("Tiempo de Multiplicación: " + (endTime-startTime) + "ms");
        System.out.println();

        return resultMatrix;
    }

    @Override
    public double[][] InversaG() {
        long startTime = System.currentTimeMillis();
        int Column = this.getColumnDimension();
        double Inversa[][] = new double[Column][Column];
        double InversaM[][] = matrixData;

        for (int i = 0; i < Column; i++)
            for (int j = 0; j < Column; j++)
                Inversa[i][j] = 0;

        for (int i = 0; i < Column; i++)
            Inversa[i][i] = 1;


        for (int k = 0; k < Column; k++)
        {
            for (int i = k; i < Column; i++)
            {
                double valInv = 1.0 / InversaM[i][k];
                for (int j = k; j < Column; j++)
                    InversaM[i][j] *= valInv;
                for (int j = 0; j < Column; j++)
                    Inversa[i][j] *= valInv;
            }
            for (int i = k + 1; i < Column; i++)
            {
                for (int j = k; j < Column; j++)
                    InversaM[i][j] -= InversaM[k][j];
                for (int j = 0; j < Column; j++)
                    Inversa[i][j] -= Inversa[k][j];
            }
        }

        for (int i = Column - 2; i >= 0; i--)
        {
            for (int j = Column - 1; j > i; j--)
            {
                for (int k = 0; k < Column; k++)
                    Inversa[i][k] -= InversaM[i][j] * Inversa[j][k];
                for (int k = 0; k < Column; k++)
                    InversaM[i][k] -= InversaM[i][j] * InversaM[j][k];
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println ("Tiempo de Inversa: " + (endTime-startTime) + "ms");
        return Inversa;
    }

}