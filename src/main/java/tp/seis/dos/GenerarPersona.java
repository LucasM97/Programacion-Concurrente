package tp.seis.dos;

import java.util.Random;

public class GenerarPersona {
    private static final Random random = new Random();

    public static Persona aleatoria() {
        boolean generarHombre = random.nextBoolean();
        if (generarHombre) return new Hombre();
        return new Mujer();
    }
}
