package tp.cinco.unoA;

import java.util.ArrayList;
import java.util.Random;

public class Consumidor extends Thread {
    int i;
    ArrayList<Integer> lista;

    public Consumidor(ArrayList<Integer> lista, int i) {
        this.lista = lista;
        this.i = i;
    }

    @Override
    public void run() {
        int I = 400, S = 800;
        Random random = new Random();
        synchronized (lista) {
            while (lista.size() == 0) {
                System.out.println("Consumidor " + i + " : No hay elementos para consumir, me duermo");
                try {
                    lista.wait();
                    System.out.println("Consumidor " + i + " : Me despertaron");
                    Thread.sleep(random.nextInt((S - I) + 1) + I);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int consumido = lista.remove(0);
            System.out.println("Consumidor " + i + " : Consumido: " + consumido);
        }
    }
}
