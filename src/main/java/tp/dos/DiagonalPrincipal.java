package tp.dos;

public class DiagonalPrincipal extends MatrizCuadrada<Integer>{
    private final static int TAMANIO = 7;

    public DiagonalPrincipal() {
        super(TAMANIO);
        completarDiagonalPrincipal();
        completarConPrimo();
    }

    public void completarDiagonalPrincipal() {
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                if (i == j) agregar(j,i,1);
            }
        }
    }

    public void completarConPrimo() {
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                if (super.dato(j,i) == null) agregar(j,i,Aleatorio.primo(100));
            }
        }
    }
}
