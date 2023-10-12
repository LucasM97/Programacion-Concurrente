package tp.tres.clase;

public class Principal1 {
    public static void main(String[] args) {

        long inicio, fin;

        Thread mishilos[] = new Thread[20];

        inicio = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {

            PrintX hilox = new PrintX(i);
            PrintY hiloy = new PrintY(i);

            hilox.start();
            hiloy.start();

            try {
                hilox.join();
                hiloy.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("");
        }

        fin = System.currentTimeMillis();

        System.out.println("");
        System.out.println("Total ejecucion " + (fin-inicio));











        /*
        try {
            //Thread.sleep(500);
            hilox.join();
            hiloy.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 100; i++) {
            System.out.println("\nHola " + i);
        }
        */
    }
}
