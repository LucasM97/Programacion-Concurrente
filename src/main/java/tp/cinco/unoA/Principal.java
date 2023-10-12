package tp.cinco.unoA;

import java.util.ArrayList;
import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        int I = 100, S = 200, i = -1;
        Random random = new Random();
        ArrayList<Integer> miLista = new ArrayList<>();

        while (true) {
            i++;
            Productor productor = new Productor(miLista,i);
            Consumidor consumidor = new Consumidor(miLista,i);
            try {
                productor.start();
                consumidor.start();
                Thread.sleep(random.nextInt((S - I) + 1) + I);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
