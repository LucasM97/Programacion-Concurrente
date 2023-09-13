package tp.dos;

public class MatrizCuadrada<E> {
    private final static int TAMANIO = 5;

    private E[][] matriz;

    public MatrizCuadrada() {
        this(MatrizCuadrada.TAMANIO);
    }

    public MatrizCuadrada(int tamanio) {
        if (tamanio <= 0) throw new RuntimeException("El tamaño no es valido");
        this.matriz = (E[][]) new Object[tamanio][tamanio];
    }

    public void agregar(int x, int y, E dato) {
        matriz[x][y] = dato;
    }

    public E dato(int x, int y) {
        return matriz[x][y];
    }

    public int size() {
        return this.matriz.length;
    }

    public void copiar(MatrizCuadrada<E> matriz) {
        if (size() != matriz.size()) throw new RuntimeException("La Matriz no tiene el mismo tamaño");
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                this.matriz[j][i] = matriz.dato(j,i);
            }
        }
    }

    @Override
    public String toString() {
        if (size() <= 0) throw new RuntimeException("Matriz vacía");
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                builder.append(matriz[j][i] + "\t");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
