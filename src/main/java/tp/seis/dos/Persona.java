package tp.seis.dos;

import java.util.Objects;
import java.util.Random;

public class Persona {
    private String sexo;
    private int numeroPersona;

    public Persona(String sexo, int numeroPersona) {
        setSexo(sexo);
        setNumeroPersona(numeroPersona);
    }

    public int getNumeroPersona() {
        return numeroPersona;
    }

    public void setNumeroPersona(int numeroPersona) {
        this.numeroPersona = numeroPersona;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean soyHombre() {
        return Objects.equals(this.getSexo(), "HOMBRE");
    }

    public boolean soyMujer() { return Objects.equals(this.getSexo(), "MUJER"); }

    public static Persona aleatoria() {
        Random random = new Random();
        boolean generarHombre = random.nextBoolean();
        if (generarHombre) return new Hombre();
        return new Mujer();
    }

    @Override
    public String toString() {
        return getSexo() + " " + getNumeroPersona();
    }
}
