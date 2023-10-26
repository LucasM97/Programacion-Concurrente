package tp.seis.dos;

public class Mujer extends Persona {
    private static final String SEXO = "MUJER";
    public static int numeroMujer = 1;

    public Mujer() {
        super(SEXO, numeroMujer);
        numeroMujer++;
    }
}
