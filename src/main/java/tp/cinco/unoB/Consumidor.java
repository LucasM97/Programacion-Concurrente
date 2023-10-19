package tp.cinco.unoB;

public class Consumidor extends Thread {
    int i;
    ArrayLimitado<Integer> lista;

    public Consumidor(ArrayLimitado<Integer> lista, int i) {
        this.lista = lista;
        this.i = i;
    }

    @Override
    public void run() {
        ToolThread.sleep(1000, 1500);
        lista.remove(i);
    }
}
