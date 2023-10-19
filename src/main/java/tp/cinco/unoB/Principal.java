package tp.cinco.unoB;

public class Principal {
    public static void main(String[] args) {
        int i = 0;
        ArrayLimitado<Integer> miLista = new ArrayLimitado<>();

        while (true) {
            Productor productor = new Productor(miLista, i);
            Consumidor consumidor = new Consumidor(miLista, i);

            productor.start();
            consumidor.start();

            ToolThread.sleep(100, 200);

            i++;
        }
    }
}
