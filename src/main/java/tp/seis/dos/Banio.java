package tp.seis.dos;

import java.util.ArrayList;

public class Banio {
    private final int capacidadMaxima;
    private boolean turno;
    private final ArrayList<Persona> banio;
    private final ArrayList<Persona> esperaHombres;
    private final ArrayList<Persona> esperaMujer;

    public Banio() {
        this(3);
    }

    public Banio(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        banio = new ArrayList<>();
        esperaHombres = new ArrayList<>();
        esperaMujer = new ArrayList<>();
    }

    public synchronized void add(Persona persona) {
        asignarTurnoDeInicio(persona);
        System.out.println(persona + " quiere entrar al baño");
        switch (persona.getSexo()){
            case "HOMBRE":
                while (isFull() || !puedeEntrarHombre(persona)) {
                    if (hayMujeresEsperando()) System.out.println("¡¡¡ Hay mujeres esperando !!!");
                    System.out.println(persona + " no puede ocupar el baño");
                    System.out.println(persona + " esperando...");
                    agregarAEspera(persona);
                    try {
                        wait();
                        System.out.println(persona + " ya puede ocupar el baño");
                        salirDeEspera(persona);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                banio.add(persona);
                System.out.println(persona + " entro al baño");
                Contador.incrementarContadorHombres();
                System.out.println("Contador Hombres: " + Contador.getContadorHombres());
                actualizarTurno();
                break;
            case "MUJER" :
                while (isFull() || !puedeEntrarMujer(persona)) {
                    if (hayHombresEsperando()) System.out.println("¡¡¡ Hay hombres esperando !!!");
                    System.out.println(persona + " no puede ocupar el baño");
                    System.out.println(persona + " esperando...");
                    agregarAEspera(persona);
                    try {
                        wait();
                        System.out.println(persona + " ya puede entrar la baño");
                        salirDeEspera(persona);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                banio.add(persona);
                System.out.println(persona + " entro al baño");
                Contador.incrementarContadorMujeres();
                System.out.println("Contador Mujeres: " + Contador.getContadorMujeres());
                actualizarTurno();
                break;

        }
    }

    public synchronized void remove() {
        if (!banio.isEmpty()) {
            System.out.println(banio.remove(0) + " salio del baño");
            notifyAll();
        }
    }

    public void asignarTurnoDeInicio(Persona persona) {
        if (Contador.getContadorHombres() == 0 && Contador.getContadorMujeres() == 0 && persona.soyHombre()) {
            System.out.println("\n##### Inicia el prioridad de hombres #####\n");
            turno = true;
        }
        if (Contador.getContadorHombres() == 0 && Contador.getContadorMujeres() == 0 && persona.soyMujer()) {
            System.out.println("\n##### Inicia el prioridad de mujeres #####\n");
            turno = false;
        }
    }

    public void actualizarTurno() {
        if (Contador.getContadorHombres() == Contador.MAXIMO_HOMBRES) {
            System.out.println("\n##### Finaliza el prioridad de hombres #####");
            turno = false;
            System.out.println("##### Inicia el prioridad de mujeres #####\n");
        }
        if (Contador.getContadorMujeres() == Contador.MAXIMO_MUJERES) {
            System.out.println("\n##### Finaliza el prioridad de mujeres #####");
            turno = true;
            System.out.println("##### Inicia el prioridad de hombres #####\n");
        }
    }

    public void agregarAEspera(Persona persona) {
        if (persona.soyHombre()) {
            esperaHombres.add(persona);
        } else {
            esperaMujer.add(persona);
        }
    }

    public void salirDeEspera(Persona persona) {
        if (persona.soyHombre()) {
            esperaHombres.remove(persona);
        } else {
            esperaMujer.remove(persona);
        }
    }

    public boolean puedeEntrarHombre(Persona persona) {
        return persona.soyHombre() && !hayMujeres() && (turno || !hayMujeresEsperando());
    }

    public boolean puedeEntrarMujer(Persona persona) {
        return persona.soyMujer() && !hayHombres() && (!turno || !hayHombresEsperando());
    }

    public boolean hayHombresEsperando() { return !esperaHombres.isEmpty(); }

    public boolean hayMujeresEsperando() { return !esperaMujer.isEmpty(); }

    public boolean hayHombres() {
        for (Persona persona : banio) {
            if (persona.soyHombre()) return true;
        }
        return false;
    }

    public boolean hayMujeres() {
        for (Persona persona : banio) {
            if (persona.soyMujer()) return true;
        }
        return false;
    }

    public boolean isFull() {
        return banio.size() >= capacidadMaxima;
    }

    @Override
    public String toString() {
        if (banio.isEmpty()) return "Baño : | El baño esta vacio |";
        StringBuilder builder = new StringBuilder();
        builder.append("Baño : | ");
        for (Persona persona : banio) {
            builder.append(persona).append(" | ");
        }
        return builder.toString();
    }
}
