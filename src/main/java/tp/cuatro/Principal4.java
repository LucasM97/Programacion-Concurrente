package tp.cuatro;

public class Principal4 {
    public static void main(String[] args) {
        Matriz matrizA = new Matriz();
        Matriz matrizB = new Matriz(Matriz.COLUMNAS,Matriz.FILAS);

        Hilo[] hilos = new Hilo[Matriz.FILAS];

        System.out.println("### Matriz A ##########################################\n" + matrizA);
        System.out.println("### Matriz B ##########################################\n" + matrizB);

        for (int i = 0; i < Matriz.FILAS; i++) {
            hilos[i] = new Hilo(matrizA, matrizB, i);
            hilos[i].start();
        }

        for (Thread h : hilos) {
            try {
                h.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("### Matriz A ##########################################\n" + matrizA);
        System.out.println("### Matriz B ##########################################\n" + matrizB);
    }
}


