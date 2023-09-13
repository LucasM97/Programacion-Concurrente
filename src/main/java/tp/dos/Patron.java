package tp.dos;

public class Patron extends MatrizCuadrada<Character>{

    public Patron(int tamanio) {
        super(tamanio + tamanio - 1);
        dibujar();
    }

    public void dibujar() {
        boolean permiso = false;
        int centro = (size() - 1) / 2;

        completarDiagonalPrincipal();
        completarDiagonalOpuesta();
        completarEspacios();

        for (int i = 0; i < super.size(); i++) {
            for (int j = 0; j < super.size(); j++) {
                if (i == centro && j == centro) continue;
                if (dato(j,i) == '*') {
                    permiso = !permiso;
                    continue;
                }
                if (permiso) {
                    if (esPar(i) && esPar(j)) agregar(j,i,'*');
                    if (!esPar(i) && !esPar(j)) agregar(j,i,'*');
                }
            }
        }
    }

    public void completarDiagonalPrincipal() {
        for (int i = 0; i < super.size(); i++) {
            for (int j = 0; j < super.size(); j++) {
                if (i == j) super.agregar(i,j,'*');
            }
        }
    }

    public void completarDiagonalOpuesta() {
        for (int i = 0; i < super.size(); i++) {
            for (int j = 0; j < super.size(); j++) {
                if (i + j == super.size() - 1) super.agregar(i,j,'*');
            }
        }
    }

    public void completarEspacios() {
        for (int i = 0; i < super.size(); i++) {
            for (int j = 0; j < super.size(); j++) {
                if (dato(j,i) == null) super.agregar(j,i,' ');
            }
        }
    }

    public boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    @Override
    public String toString() {
        if (size() <= 0) throw new RuntimeException("Matriz vacía");
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < this.size(); j++) {
                builder.append(dato(j,i));
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
