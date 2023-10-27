package tp.seis.tres;

public class Operaciones {
    public static double SumRootN(int root) {
        double result = 0;
        for (int i = 0; i < 10000000; i++) {
            result += Math.exp(Math.log(i) / root);
        }
        return result;
    }
}
