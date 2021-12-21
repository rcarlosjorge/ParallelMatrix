package base;

public class Main {

    public static void main(String[] args)
    {
        SequentialMatrix matriz1 = new SequentialMatrix(50,50);
        SequentialMatrix matriz2 = new SequentialMatrix(50,50);
        double[][] producto1 = matriz1.multiply(matriz2);
        double[][] inversa1 = matriz1.InversaG();


        SequentialMatrix matriz3 = new SequentialMatrix(100,100);
        SequentialMatrix matriz4 = new SequentialMatrix(100,100);
        double[][] producto2 = matriz3.multiply(matriz4);
        double[][] inversa2 = matriz3.InversaG();


        SequentialMatrix matriz5 = new SequentialMatrix(200,200);
        SequentialMatrix matriz6 = new SequentialMatrix(200,200);
        double[][] producto3 = matriz5.multiply(matriz6);
        double[][] inversa3 = matriz5.InversaG();



        SequentialMatrix matriz7 = new SequentialMatrix(250,250);
        SequentialMatrix matriz8 = new SequentialMatrix(250,250);
        double[][] producto4 = matriz7.multiply(matriz8);
        double[][] inversa4 = matriz7.InversaG();


        SequentialMatrix matriz9  = new SequentialMatrix(300,300);
        SequentialMatrix matriz10 = new SequentialMatrix(300,300);
        double[][] producto5 = matriz9.multiply(matriz10);
        double[][] inversa5 = matriz9.InversaG();


        SequentialMatrix matriz11 = new SequentialMatrix(350,350);
        SequentialMatrix matriz12 = new SequentialMatrix(350,350);
        double[][] producto6 = matriz11.multiply(matriz12);
        double[][] inversa6 = matriz11.InversaG();

        SequentialMatrix matriz19 = new SequentialMatrix(400,400);
        SequentialMatrix matriz20 = new SequentialMatrix(400,400);
        double[][] producto10 = matriz19.multiply(matriz20);
        double[][] inversa10 = matriz19.InversaG();


        SequentialMatrix matriz13 = new SequentialMatrix(500,500);
        SequentialMatrix matriz14 = new SequentialMatrix(500,500);
        double[][] producto7 = matriz13.multiply(matriz14);
        double[][] inversa7 = matriz13.InversaG();

        SequentialMatrix matriz21 = new SequentialMatrix(700,700);
        SequentialMatrix matriz22 = new SequentialMatrix(700,700);
        double[][] producto11 = matriz21.multiply(matriz22);
        double[][] inversa11 = matriz21.InversaG();


        SequentialMatrix matriz15 = new SequentialMatrix(1000,1000);
        SequentialMatrix matriz16 = new SequentialMatrix(1000,1000);
        double[][] producto8 = matriz15.multiply(matriz16);
        double[][] inversa8 = matriz15.InversaG();


        SequentialMatrix matriz17 = new SequentialMatrix(1300,1300);
        SequentialMatrix matriz18 = new SequentialMatrix(1300,1300);
        double[][] producto9 = matriz17.multiply(matriz18);
        double[][] inversa9 = matriz17.InversaG();
    }
}
