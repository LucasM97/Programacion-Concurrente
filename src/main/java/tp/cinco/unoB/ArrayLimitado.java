package tp.cinco.unoB;

import java.util.ArrayList;

public class ArrayLimitado<Integer> {
    private static final int MAXIMO = 5;

    private ArrayList<Integer> lista;

    public ArrayLimitado() {
        lista = new ArrayList<>();
    }

    public synchronized void add(Integer valor, int id) {
        while (isFull()) {
            try {
                System.out.println("Productor " + id + " No hay espacio para agregar otro producto");
                wait();
                System.out.println("Productor " + id + " Se libero un espacio... pudo agregar un producto");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lista.add(valor);
        notify();
        System.out.println("Productor " + id + " : Numero agregado: " + valor);
        System.out.println("Productor " + id + " : Notificando......");
    }

    public synchronized Integer remove(int id) {
        Integer num;
        while (lista.isEmpty()) {
            System.out.println("Consumidor " + id + " : No hay elementos para consumir, me duermo");
            try {
                wait();
                System.out.println("Consumidor " + id + " : Me despertaron");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num = lista.remove(0);
        notify();
        System.out.println("Consumidor " + id + " : Consumido: " + num);
        return num;
    }

    public int size() {
        return lista.size();
    }

    public boolean isFull() {
        return lista.size() >= MAXIMO;
    }
}
