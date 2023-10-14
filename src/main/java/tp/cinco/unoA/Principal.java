package tp.cinco.unoA;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        int I = 100, S = 200, i = 0;
        ArrayList<Integer> lista = new ArrayList<>();

        while (true) {
            Productor productor = new Productor(lista,i);
            Consumidor consumidor = new Consumidor(lista,i);

            productor.start();
            consumidor.start();

            ToolThread.sleep(I,S);

            i++;
        }
    }
}
