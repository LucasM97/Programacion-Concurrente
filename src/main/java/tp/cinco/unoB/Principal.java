package tp.cinco.unoB;

import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        int I = 100, S = 200, i = -1;
        Random random = new Random();
        ArrayLimitado<Integer> miLista = new ArrayLimitado<>();

        while (true) {
            i++;
            try {
                if (!miLista.isFull()) {
                    Productor productor = new Productor(miLista,i);
                    productor.start();
                    Thread.sleep(random.nextInt((S - I) + 1) + I);
                }
                Consumidor consumidor = new Consumidor(miLista,i);
                consumidor.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
