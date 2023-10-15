package tp.cinco.unoB;

import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        int i = 0;
        Random random = new Random();
        ArrayLimitado<Integer> miLista = new ArrayLimitado<>();

        while (true) {
            Productor productor = new Productor(miLista,i);
            Consumidor consumidor = new Consumidor(miLista,i);

            productor.start();
            consumidor.start();

            ToolThread.sleep(100,200);

            i++;
        }
    }
}
