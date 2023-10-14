package tp.cinco.unoB;

import tp.cinco.unoA.ToolThread;

import java.util.Random;

public class Productor extends Thread {
    int i;
    ArrayLimitado<Integer> lista;

    public Productor(ArrayLimitado<Integer> lista, int i) {
        this.lista = lista;
        this.i = i;
    }

    @Override
    public void run() {
        int inicio = 10, fin = 100, I = 400, S = 800;
        Random random = new Random();
        int numero = random.nextInt((fin - inicio) + 1) + inicio;

        ToolThread.sleep(I,S);
        synchronized (lista) {
            lista.add(numero);
            lista.notify();
            System.out.println("Productor " + i + " : Numero agregado: " + numero);
            System.out.println("Productor " + i + " : Notificando......");
        }
    }
}
