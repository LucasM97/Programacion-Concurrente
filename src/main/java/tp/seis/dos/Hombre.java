package tp.seis.dos;

public class Hombre extends Persona {
    private static final String SEXO = "HOMBRE";
    public static int numeroHombre = 1;

    public Hombre() {
        super(SEXO, numeroHombre);
        numeroHombre++;
    }
}
