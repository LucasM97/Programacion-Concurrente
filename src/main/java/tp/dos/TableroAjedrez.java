package tp.dos;

import java.util.ArrayList;

public class TableroAjedrez extends MatrizCuadrada<String>{
    private final static int TAMANIO = 11;

    private final static int MOVIMIENTOS = 5;

    private Punto posicion = new Punto(10);;

    private String[] posiciones = {" ","A","B","C","D","E","F","G","H","I","J"};

    private ArrayList<Punto> movimientos = new ArrayList<>();

    public TableroAjedrez(int x, int y) {
        super(TableroAjedrez.TAMANIO);
        posicion.setX(x);
        posicion.setY(y);
        validarPunto(x, y);
        mover();
    }

    public void mover() {
        for (int i = 0; i < MOVIMIENTOS; i++) {
            actualizarTablero();
            System.out.println(this.toString());
            opcionesPosibles();
        }
    }

    public void limpiarTablero() {
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                if (i == 0) {
                    agregar(i,j,posiciones[j]);
                } else if (j == 0) {
                    agregar(i,j, Integer.toString(i));
                } else {
                    agregar(i,j,"#");
                }
            }
        }
    }

    public void actualizarTablero() {
        limpiarTablero();

        dibujarPosicion();

        actualizarMovimientosPosibles();

        dibujarMovimientosPosibles();

        actualizarPosicion();
    }

    public void dibujarPosicion() {
        this.agregar(posicion.getX(), posicion.getY(), "0");
    }

    public void actualizarPosicion() {
        posicion = movimientos.get(Aleatorio.entero(movimientos.size() - 1));
    }

    public void dibujarMovimientosPosibles() {
        for (Punto p : movimientos) {
            this.agregar(p.getX(), p.getY(), "X");
        }
    }

    public void actualizarMovimientosPosibles() {
        movimientos.clear();

        Punto puntoAux = new Punto();

        puntoAux.setX(posicion.getX() - 1);
        puntoAux.setY(posicion.getY() - 2);
        if (validarPunto(puntoAux.getX(), puntoAux.getY())) movimientos.add(new Punto(puntoAux.getX(), puntoAux.getY()));

        puntoAux.setX(posicion.getX() + 1);
        puntoAux.setY(posicion.getY() - 2);
        if (validarPunto(puntoAux.getX(), puntoAux.getY())) movimientos.add(new Punto(puntoAux.getX(), puntoAux.getY()));

        puntoAux.setX(posicion.getX() - 1);
        puntoAux.setY(posicion.getY() + 2);
        if (validarPunto(puntoAux.getX(), puntoAux.getY())) movimientos.add(new Punto(puntoAux.getX(), puntoAux.getY()));

        puntoAux.setX(posicion.getX() + 1);
        puntoAux.setY(posicion.getY() + 2);
        if (validarPunto(puntoAux.getX(), puntoAux.getY())) movimientos.add(new Punto(puntoAux.getX(), puntoAux.getY()));

        puntoAux.setX(posicion.getX() - 2);
        puntoAux.setY(posicion.getY() - 1);
        if (validarPunto(puntoAux.getX(), puntoAux.getY())) movimientos.add(new Punto(puntoAux.getX(), puntoAux.getY()));

        puntoAux.setX(posicion.getX() - 2);
        puntoAux.setY(posicion.getY() + 1);
        if (validarPunto(puntoAux.getX(), puntoAux.getY())) movimientos.add(new Punto(puntoAux.getX(), puntoAux.getY()));

        puntoAux.setX(posicion.getX() + 2);
        puntoAux.setY(posicion.getY() - 1);
        if (validarPunto(puntoAux.getX(), puntoAux.getY())) movimientos.add(new Punto(puntoAux.getX(), puntoAux.getY()));

        puntoAux.setX(posicion.getX() + 2);
        puntoAux.setY(posicion.getY() + 1);
        if (validarPunto(puntoAux.getX(), puntoAux.getY())) movimientos.add(new Punto(puntoAux.getX(), puntoAux.getY()));
    }

    public void opcionesPosibles() {
        StringBuilder builder = new StringBuilder();
        builder.append("Movimientos posibles:");
        for (Punto p : movimientos) {
            builder.append(" [" + p.getX() + "," + posiciones[p.getY()] + "]");
        }
        System.out.println(builder.toString());
    }

    public boolean validarPunto(int x, int y) {
        return ((x <= 10 && x >= 1) && (y <= 10 && y >= 1));
    }
}
