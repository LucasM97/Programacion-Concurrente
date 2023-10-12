package prueva;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        ArrayList<Integer> miLista = new ArrayList<>();

        Productor productor = new Productor(miLista,0);
        productor.start();

        for (int i = 0; i < 10; i++) {
            Consumidor consumidor = new Consumidor(miLista,i);
            consumidor.start();
        }
    }
}
