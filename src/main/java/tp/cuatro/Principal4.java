package tp.cuatro;

public class Principal4 {
    public static void main(String[] args) {
        Matriz matrizA = new Matriz();
        Matriz matrizB = new Matriz(Matriz.COLUMNAS,Matriz.FILAS);

        Thread[] hilos = new Thread[Matriz.FILAS];

        System.out.println(matrizA);
        System.out.println(matrizB);

        for (int i = 0; i < Matriz.FILAS; i++) {
            hilos[i] = new Thread(new Hilo(matrizA, matrizB));
            hilos[i].start();
        }

        for (Thread h : hilos) {
            try {
                h.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(matrizA);
        System.out.println(matrizB);
    }
}


