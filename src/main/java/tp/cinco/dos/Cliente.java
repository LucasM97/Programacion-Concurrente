package tp.cinco.dos;

public class Cliente extends Thread {
    int numeroCliente;
    private final Mostrador mostrador;

    public Cliente(Mostrador mostrador, int numeroCliente) {
        this.mostrador = mostrador;
        this.numeroCliente = numeroCliente;
    }

    @Override
    public void run() {
        System.out.println("Cliente " + numeroCliente + " ingreso a la panaderia");
        mostrador.remove(numeroCliente);
        ToolThread.sleep(200, 400);
    }
}
