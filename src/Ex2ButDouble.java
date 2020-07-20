import java.util.Random;

 import java.util.Scanner;
 //___________________________________________|
 //           EX2 FUNDAMENTOS PROGRAMA        |
 //                LUIZA LENCINA              |
 //___________________________________________|
public class Ex2ButDouble {
    public static void main(String[] args){
        System.out.println("Cria uma matriz 5x6");
        System.out.println("Os valores impressos na tela estao arredondados (valores como .9999 podem aparecer como '1.0'");
        System.out.println("mas nao sao interpretados como '1.0' pelo programa e estao sendo impressos desta forma apenas para");
        System.out.println("reduzir a poluicao na tela");
        double[][] matriz = randomBinaryMatrix(5, 6);
        for(int i = 0; i < matriz.length; i++){
            System.out.print("[  ");
            for(int j = 0; j < matriz[i].length; j++){
                System.out.print(String.format("%.3f  ", matriz[i][j]));
            }
            System.out.println("]");
        }
        System.out.println("Gera um vetor que contem a quantidade de 1s por linha:");
        int[] ones = countOnes(matriz);
        for(int i = 0; i < ones.length; i++){
            System.out.println("Na linha "+i+" nos temos "+ones[i]+" 1s");
        }
    }

    public static double[][] randomBinaryMatrix(int i, int j){
        Random luck = new Random();
        double[][] bMatrix = new double[i][j];
        for(int k = 0; k < bMatrix.length; k++){
            for(int l = 0; l < bMatrix[k].length; l++){
                // "forca" a presenca de 1s na matriz (1s nao sao garantidos, mas sao bem provaveis)
                if(luck.nextInt(25)%5==0)bMatrix[k][l]=1.0;
                else bMatrix[k][l] = luck.nextDouble();
            }
        }
        return bMatrix;
    }
    public static int[] countOnes(double[][] bMatrix){
        int[] ones = new int[bMatrix.length];
        for(int i = 0; i < bMatrix.length; i++){
            int count = 0;
            for(int j = 0; j < bMatrix[i].length; j++){
                if(bMatrix[i][j]==1.0) count++;
            }
            ones[i] = count;
        }
        return ones;
    }
}