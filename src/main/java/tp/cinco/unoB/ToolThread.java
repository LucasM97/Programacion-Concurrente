package tp.cinco.unoB;

import java.util.Random;

public class ToolThread extends Thread {
    public ToolThread() {
        super();
    }

    public static void sleep(int inicio, int fin) {
        Random random = new Random();
        int num = random.nextInt((fin - inicio) + 1) + inicio;

        try {
            sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
