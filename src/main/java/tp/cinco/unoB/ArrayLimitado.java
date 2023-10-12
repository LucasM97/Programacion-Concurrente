package tp.cinco.unoB;

import java.util.ArrayList;

public class ArrayLimitado<Integer> {
    private static final int MAXIMO = 5;

    private ArrayList<Integer> lista;

    public ArrayLimitado() {
        lista = new ArrayList<>();
    }

    public void add(Integer valor) {
        if (!isFull()) {
            lista.add(valor);
        }
    }

    public Integer remove() {
        if (lista.size() <= 0) throw new RuntimeException("Erroe: No hay elemetos para extraer");
        return lista.remove(0);
    }

    public int size() {
        return lista.size();
    }

    public boolean isFull() {
        return lista.size() >= MAXIMO;
    }
}
