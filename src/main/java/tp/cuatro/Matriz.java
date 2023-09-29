package tp.cuatro;

/**
 * Clase Matriz
 *
 * La clase Matriz define la region critica.
 * Esta compuesta por los atributos constantes FILAS, para definir un valor
 * de filas por defecto, COLUMNAS para definir un valor de columnas por degecto
 * y por un array bidimencional en le que se almacenan los datos.
 *
 * Tambien posee los metodos
 *
 * Constructor: permite definir las dimenciones de la matriz
 * o asignarle los valres por defecto en caso de crear un objeto con el
 * constructor sin parametros.
 *
 * agregar: añade un numero entero a la matriz en la poscicion
 * especificada.
 *
 * dato: retorna el dato en en la posicion especificada
 *
 * cargarMatriz: carga la matriz matriz con números aleatorios
 *
 * Se sobre-escribe el metodo toString para mostrar la matriz
 * */


public class Matriz {
    public final static int FILAS = 100;
    public final static int COLUMNAS = 200;
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
                matriz[i][j] = (int) (Math.random() * 100 + 1);
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
