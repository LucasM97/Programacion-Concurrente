package tp.cuatro;

public class Principal4 {
    public static void main(String[] args) {
        Matriz matrizA = new Matriz(6, 7);
        Matriz matrizB = new Matriz(matrizA.columnas, matrizA.filas);

        Hilo[] hilos = new Hilo[matrizA.filas];

        System.out.println("### Matriz A ##########################################\n" + matrizA);
        System.out.println("### Matriz B ##########################################\n" + matrizB);

        for (int i = 0; i < matrizA.filas; i++) {
            hilos[i] = new Hilo(matrizA, matrizB, i);
            hilos[i].start();
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("### Matriz A ##########################################\n" + matrizA);
        System.out.println("### Matriz B ##########################################\n" + matrizB);
    }
}


