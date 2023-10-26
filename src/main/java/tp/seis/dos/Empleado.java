package tp.seis.dos;

public class Empleado implements Runnable {
    private final static Banio banio = new Banio();
    private final Persona persona;

    public Empleado(Persona persona) {
        this.persona = persona;
    }

    public static void main(String[] args) {
        while (true) {
            Persona persona = GenerarPersona.aleatoria();
            Runnable empleado = new Empleado(persona);
            new Thread(empleado).start();
            ToolThread.sleep(600, 1200);
        }
    }

    @Override
    public void run() {
        System.out.println(banio);

        banio.add(persona);

        if (persona.soyHombre()) {
            ToolThread.sleep(400, 900);
        } else {
            ToolThread.sleep(800, 1500);
        }

        banio.remove();
    }
}
