package tp.cinco.dos;

public class Principal {
    public static void main(String[] args) {
        int numeroCliente = 1;
        Mostrador mostrador = new Mostrador();

        HornoBizcocho hBizcochos = new HornoBizcocho(mostrador);
        HornoFactura hFacturas = new HornoFactura(mostrador);

        hBizcochos.start();
        hFacturas.start();

        while (true) {
            Cliente cliente = new Cliente(mostrador, numeroCliente);
            cliente.start();
            ToolThread.sleep(800, 1500);
            numeroCliente++;
        }
    }
}
