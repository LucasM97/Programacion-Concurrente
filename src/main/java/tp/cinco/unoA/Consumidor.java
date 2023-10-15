package tp.cinco.unoA;

import java.util.ArrayList;

public class Consumidor extends Thread {
    int i;
    ArrayList<Integer> lista;

    public Consumidor(ArrayList<Integer> lista, int i) {
        this.lista = lista;
        this.i = i;
    }

    @Override
    public void run() {
        synchronized (lista) {
            while (lista.size() == 0) {
                System.out.println("Consumidor " + i + " : No hay elementos para consumir, me duermo");
                try {
                    lista.wait();
                    System.out.println("Consumidor " + i + " : Me despertaron");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ToolThread.sleep(400,800);
            int consumido = lista.remove(0);
            System.out.println("Consumidor " + i + " : Consumido: " + consumido);
        }
    }
}
