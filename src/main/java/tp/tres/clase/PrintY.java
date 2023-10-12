package tp.tres.clase;

public class PrintY extends Thread{

    private int indice;

    public PrintY(int i) {
        indice = i;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print("."+i+"Y("+indice+")");
        }
    }
}
