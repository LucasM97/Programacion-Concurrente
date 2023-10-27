package tp.seis.tres;

public class Principal {
    public static void main(String[] args) {
        Matriz matrizA = new Matriz();
        Matriz matrizB = new Matriz(matrizA.getColumnas(), matrizA.getFilas());
        Matriz matrizC = new Matriz(matrizA.getFilas(), matrizB.getColumnas());

        Thread[] hilos = new Thread[matrizA.getFilas()];

        System.out.println((int) Operaciones.SumRootN(81));

        System.out.println("### Matriz A ##########################################\n" + matrizA);
        System.out.println("### Matriz B ##########################################\n" + matrizB);

        long tiempoInicio = System.currentTimeMillis();

        for (int i = 0; i < matrizA.getFilas(); i++) {
            hilos[i] = new Thread(new CalculoConcurrente(matrizA, matrizB, matrizC, i));
            hilos[i].start();
        }

        for (Thread h : hilos) {
            try {
                h.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("### Matriz C ##########################################\n" + matrizC);

        long tiempoFinal = System.currentTimeMillis() - tiempoInicio;

        System.out.println("\nTiempo de ejecución : " + tiempoFinal / 1000. + "s");
    }
}


