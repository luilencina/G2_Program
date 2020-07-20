import java.util.InputMismatchException;
import java.util.Scanner;

import java.util.Scanner;
//___________________________________________|
//         EX1 -- FUNDAMENTOS PROGRAM        |
//                LUIZA LENCINA              |
//___________________________________________|
public class Ex1 {
    public static void main(String[] args) throws Exception {
        int n = 0;

        try(Scanner console = new Scanner(System.in)){
            System.out.println("Este programa imprime o resultado serie definida por:");
            System.out.println("Somatorio de x^(2*j)/(2*j)+1 \ncom j variando de 0 até (n-1)");
            System.out.println("Com n inteiro, x real");
            System.out.println("Digite um n nao-positivo para sair");
            System.out.print("Digite o valor de n: ");
            n = console.nextInt();
            while(n>0){
            StringBuilder sb = new StringBuilder();
            System.out.print("Digite o valor de x: ");
            double x = console.nextDouble();
            System.out.print("\nSolucao Iterativa:");
            sb.append("S(").append(x).append(") com ").append(n).append(" termos = ").append(Series.iterativo(n, x));
            System.out.println(sb);

            sb.setLength(0);
            System.out.print("Solução Recursiva:");
            sb.append("S(").append(x).append(") com ").append(n).append(" termos = ").append(Series.recursive(n, x));
            System.out.println(sb);
            System.out.println("---------------");
            System.out.println("Digite um n nao-positivo para sair");
            System.out.println("\nDigite o valor de n: ");
            n = console.nextInt();
            }
        }
        catch(InputMismatchException e){
            System.out.println("Isso não é um número!");
            System.exit(0);
        }
    }
}
