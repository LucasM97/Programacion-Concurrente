package tp.dos;

import java.util.Random;

public class Aleatorio {

    private static final Random random = new Random();

    public static Integer entero(int limiteSuperior) {
        return entero(0,limiteSuperior);
    }

    public static Integer entero(int limiteInferior, int limiteSuperior) {
        return random.nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;
    }

    public static Integer primo(int limite) {
        int aux;

        while (true) {
            aux = entero(1,limite);
            if (esPrimo(aux)) return aux;
        }
    }

    public static Double decimal(double limiteInferior, double limiteSuperior) {
        double numero = random.nextDouble() * (limiteSuperior - limiteInferior + 1) + limiteInferior;
        return (double) Math.round(numero * 100) / 100;
    }

    public static Character caracter() {
        return (char) (random.nextInt(26) + 'A');
    }

    private static boolean esPrimo(int numero){
        int i = 2;

        if (numero < 1) throw new RuntimeException("El número ingresado no es valido");
        if (numero <= 3) return true;
        while(i <= numero/2){
            if (numero % i == 0) return false;
            i++;
        }
        return true;
    }
}
