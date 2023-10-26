package tp.cuatro;

public class Matriz {
    public final static int FILAS = 4;
    public final static int COLUMNAS = 8;
    private int[][] matriz;

    public Matriz() {
        this(Matriz.FILAS, Matriz.COLUMNAS);
    }

    public Matriz(int filas, int columnas) {
        if (filas <= 0 || columnas <= 0) throw new RuntimeException("El tamaño no es valido");
        this.matriz = new int[filas][columnas];
        cargarMatriz();
    }

    public void agregar(int x, int y, int dato) {
        matriz[x][y] = dato;
    }

    public int dato(int x, int y) {
        return matriz[x][y];
    }

    public void cargarMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random() * 9 + 1);
            }
        }
    }

    @Override
    public String toString() {
        if (matriz.length <= 0) throw new RuntimeException("Matriz vacía");
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                builder.append(matriz[i][j] + "\t");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
