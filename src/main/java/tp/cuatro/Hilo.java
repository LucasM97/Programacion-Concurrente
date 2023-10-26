package tp.cuatro;

public class Hilo extends Thread{
    private final Matriz matrizA;
    private final Matriz matrizB;
    private final int numeroFila;

    public Hilo(Matriz matrizA, Matriz matrizB, int numeroFila) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
        this.numeroFila = numeroFila;
    }

    public void run() {
        int[] fila = new int[Matriz.COLUMNAS];

        for (int j = 0; j < Matriz.COLUMNAS; j++) {
            fila[j] = matrizA.dato(numeroFila, j);
            matrizA.agregar(numeroFila, j, matrizB.dato(j, numeroFila));
            matrizB.agregar(j, numeroFila, fila[j]);
        }
    }
}
