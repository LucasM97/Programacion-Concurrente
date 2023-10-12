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
        int inicio = 10, fin = 100, I = 1000, S = 1500;
        Random random = new Random();
        int numero = random.nextInt((fin - inicio) + 1) + inicio;

        try {
            Thread.sleep(random.nextInt((S - I) + 1) + I);
            synchronized (lista) {
                lista.add(numero);
                lista.notify();
                System.out.println("Productor " + i + " : Numero agregado: " + numero);
                System.out.println("Productor " + i + " : Notificando......");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
