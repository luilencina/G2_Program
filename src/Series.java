import java.lang.Math;


public class Series {

    //Calcula valor da series ITERATIVAMENTE
    public static Double iterativo(int n, Double x) throws IllegalArgumentException{
        if(n<=0) throw new IllegalAccessError("Deve ter no minimo um numero inteiro e positivo");
        Double returnValue = 0.0;
        for(int i = 0; i < n; i++){
            int iDoubled = i * 2;
            double numerator = Math.pow(x, iDoubled);
            double denominator = iDoubled+1;
            returnValue += numerator/denominator;
        }
        return returnValue;
    }

    //calcula valor da serie RECURSIVAMENTE
    public static Double recursive(int n, Double x) throws IllegalArgumentException{
        if(n<=0) throw new IllegalAccessError("Deve ter no minimo um numero inteiro e positivo");
        if(n==1) return 1.0;
        int iDoubled = (n-1)*2;
        double numerator = Math.pow(x, iDoubled);
        double denominator = iDoubled+1;
        return (numerator/denominator) + recursive(n-1, x);
    }
}