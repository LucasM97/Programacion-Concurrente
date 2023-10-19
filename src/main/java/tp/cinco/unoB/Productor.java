package tp.cinco.unoB;

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
        int inicio = 10, fin = 100;
        Random random = new Random();
        int numero = random.nextInt((fin - inicio) + 1) + inicio;

        ToolThread.sleep(400, 800);
        lista.add(numero, i);
    }
}
