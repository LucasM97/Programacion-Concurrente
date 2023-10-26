package tp.seis.dos;

public class Contador {
    public static final int MAXIMO_HOMBRES = 10;
    public static final int MAXIMO_MUJERES = 7;
    private static int contadorHombres;
    private static int contadorMujeres;

    public Contador() {
        contadorHombres = 0;
        contadorMujeres = 0;
    }

    public static int getContadorHombres() {
        return contadorHombres;
    }

    public static void incrementarContadorHombres() {
        contadorHombres++;
        if (contadorHombres > MAXIMO_HOMBRES) contadorHombres = 1;
    }

    public static int getContadorMujeres() {
        return contadorMujeres;
    }

    public static void incrementarContadorMujeres() {
        contadorMujeres++;
        if (contadorMujeres > MAXIMO_MUJERES) contadorMujeres = 1;
    }
}
