package tp.cinco.dos;

public class HornoBizcocho extends Thread {
    private Mostrador mostrador;

    public HornoBizcocho(Mostrador mostrador) {
        this.mostrador = mostrador;
    }

    @Override
    public void run() {
        int numero = 1;

        while (true) {
            ToolThread.sleep(400, 600);
            Producto bizcocho = new Bizcocho(numero);

            System.out.println("Horno de Bizcocho: Produciendo... " + bizcocho.getNombre() + " numero " + bizcocho.getNumero());
            mostrador.add(bizcocho);

            numero++;
        }
    }
}
