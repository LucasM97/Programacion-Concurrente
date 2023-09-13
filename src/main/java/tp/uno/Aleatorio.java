package tp.uno;

import java.util.Random;

public class Aleatorio {

    private static final String[] instituciones = {"Institucion 1", "Institucion 2","Institucion 3", "Institucion 4", "Institucion 5"};
    private static final String[] beneficios = {"Beneficio 1", "Beneficio 2", "Beneficio 3", "Beneficio 4", "Beneficio 5"};
    private static final Random random = new Random();

    public static Integer entero(int limiteInferior, int limiteSuperior) {
        return random.nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;
    }


    public static double decimal(double limiteInferior, double limiteSuperior) {
        double numero = random.nextDouble() * (limiteSuperior - limiteInferior + 1) + limiteInferior;
        return (double) Math.round(numero * 100) / 100;
    }

    public static long dni() {
        return entero(10000000,50000000);
    }

    public static double monto(double limiteInferior, double limiteSuperior) {
        return decimal(limiteInferior, limiteSuperior);
    }

    public static double interes() {
        return decimal(0, 200);
    }

    public static int legajo() {
        return entero(10000, 99999);
    }

    public static String institucion() {
        return instituciones[entero(1, instituciones.length) - 1];
    }

    public static String beneficio() {
        return beneficios[entero(1, beneficios.length) - 1];
    }

    public static long cbu() {
        long cbu = 0L;

        for(int i = 0; i < 18; i++) {
            cbu = (long)(cbu + random.nextInt(10) * Math.pow(10,i));
        }

        return cbu;
    }
}
