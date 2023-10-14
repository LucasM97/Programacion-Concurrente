package tp.cinco.unoA;

import java.util.ArrayList;
import java.util.Random;

public class Productor extends Thread {
    int i;
    ArrayList<Integer> lista;

    public Productor(ArrayList<Integer> lista, int i) {
        this.lista = lista;
        this.i = i;
    }

    @Override
    public void run() {
        int inicio = 10, fin = 100;
        Random random = new Random();
        int numero = random.nextInt((fin - inicio) + 1) + inicio;

        ToolThread.sleep(1000,1500);
        synchronized (lista) {
            lista.add(numero);
            lista.notify();
            System.out.println("Productor " + i + " : Numero agregado: " + numero);
            System.out.println("Productor " + i + " : Notificando......");
        }
    }
}
