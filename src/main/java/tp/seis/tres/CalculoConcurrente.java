package tp.seis.tres;

public class CalculoConcurrente extends Operaciones implements Runnable {
    private final Matriz matrizA;
    private final Matriz matrizB;
    private final Matriz matrizC;
    private final int numeroFila;

    public CalculoConcurrente(Matriz matrizA, Matriz matrizB, Matriz matrizC, int numeroFila) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
        this.matrizC = matrizC;
        this.numeroFila = numeroFila;
    }

    public synchronized void run() {
        int multiplicacion;
        for (int i = 0; i < matrizB.getColumnas(); i++) {
            multiplicacion = 0;
            for (int j = 0; j < matrizA.getColumnas(); j++){
                multiplicacion += matrizA.dato(numeroFila, j) * matrizB.dato(j, i);
                matrizC.agregar(numeroFila, i, (int) SumRootN(multiplicacion));
            }
        }
    }
}
