package tp.cinco.dos;

import java.util.ArrayList;

public class Mostrador {

    private final ArrayList<Producto> mostrador;

    public Mostrador() {
        this.mostrador = new ArrayList<>();
    }

    public synchronized void add(Producto producto) {
        mostrador.add(producto);
        notify();
        System.out.println(producto.getNombre() + " " + producto.getNumero() + " agregado/a al mostrador");
    }

    public synchronized void remove(int numeroCliente) {
        Producto productoAux;
        while (mostrador.isEmpty()) {
            System.out.println("Cliente " + numeroCliente + " : No hay productos en el mostrador... Esperando...");
            try {
                wait();
                System.out.println("Cliente " + numeroCliente + " : comprando...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        productoAux = mostrador.remove(0);
        System.out.println("Cliente " + numeroCliente + " compró " + productoAux.getNombre() + " " + productoAux.getNumero());
    }
}
