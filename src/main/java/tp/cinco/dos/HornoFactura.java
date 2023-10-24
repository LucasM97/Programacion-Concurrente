package tp.cinco.dos;

public class HornoFactura extends Thread {
    private final Mostrador mostrador;

    public HornoFactura(Mostrador mostrador) {
        this.mostrador = mostrador;
    }

    @Override
    public void run() {
        int numero = 1;

        while (true) {
            ToolThread.sleep(1000, 1300);
            Producto factura = new Factura(numero);

            System.out.println("Horno de Factura: Produciendo... " + factura.getNombre() + " numero " + factura.getNumero());
            mostrador.add(factura);

            numero++;
        }
    }
}
