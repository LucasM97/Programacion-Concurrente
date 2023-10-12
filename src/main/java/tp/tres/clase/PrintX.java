package tp.tres.clase;

public class PrintX extends Thread{
    private int indice;

    public PrintX(int i) {
        indice = i;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print("."+i+"X("+indice+")");
        }
    }
}
