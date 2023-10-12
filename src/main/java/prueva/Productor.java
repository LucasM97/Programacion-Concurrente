package prueva;

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
        int inicio = 10, fin = 100, I = 100, S = 500;
        Random random = new Random();

        for (int j = 0; j < 10; j++) {
            int numero = random.nextInt((fin - inicio) + 1) + inicio;
            try {
                Thread.sleep(random.nextInt((S - I) + 1) + I);
                synchronized (lista) {
                    lista.add(numero);
                    lista.notify();
                    System.out.println("Productor: Numero agregado: " + numero);
                }
                System.out.println("Productor: Notificando......");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
