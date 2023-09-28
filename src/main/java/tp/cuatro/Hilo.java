package tp.cuatro;

public class Hilo extends Thread{
    private Matriz matrizA;
    private Matriz matrizB;

    public Hilo(Matriz matrizA, Matriz matrizB) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
    }

    public void run() {
        synchronized (matrizA) {
            int fila[] = new int[Matriz.FILAS];

            for (int i = 0; i < Matriz.FILAS; i++) {
                for (int j = 0; j < Matriz.COLUMNAS; j++) {
                    fila[i] = matrizA.dato(i,j);
                    matrizA.agregar(i,j,matrizB.dato(j,i));
                    matrizB.agregar(j,i,fila[i]);
                }
            }
        }
    }
}
