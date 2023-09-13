package tp.dos;

public class SopaDeLetra extends MatrizCuadrada<Character>{
    private final static int TAMANIO = 12;

    private static String[] palabras =
            {
                    "CAMELLO",
                    "ELEFANTE",
                    "AGUIDA",
                    "CAMALEON",
                    "AVESTRUZ",
                    "COCODRILO",
                    "ANTILOPE",
                    "SERPIENTE",
                    "BUFALO",
                    "COMADREJA"
            };

    SopaDeLetra() {
        super(SopaDeLetra.TAMANIO);
        cargarTablero();
        completarConLetra();
    }

    public void cargarTablero() {
        cargarDerechaIzquierda(palabras[0]);
        cargarIzquierdaDerecha(palabras[1]);
    }

    public void cargarDerechaIzquierda(String palabra) {
        boolean agregado = false;
        MatrizCuadrada<Character> matrizAux;
        Punto punto;
        Character letra;

        while (!agregado) {
            punto = new Punto();
            matrizAux = new MatrizCuadrada<>(SopaDeLetra.TAMANIO);
            matrizAux.copiar(this);

            if (validarDerechaIzquierda(punto, palabra)) {
                for (int i = punto.getY(); i < palabra.length() + punto.getY(); i++) {
                    letra = palabra.charAt(i - punto.getY());
                    if (!coincidencia(punto.getX(), i, letra)) break;
                    matrizAux.agregar(punto.getX(), i, letra);
                    System.out.println(i+" "+(palabra.length() + punto.getY()));
                    if (i == palabra.length() + punto.getY() - 1) {
                        System.out.println(matrizAux.toString());
                        this.copiar(matrizAux);
                        agregado = true;
                    }
                }
            }
        }
    }

    public boolean validarDerechaIzquierda(Punto punto, String palabra) {
        if (punto.getY() + palabra.length() > super.size()) return false;
        return (coincidencia(punto.getY(), punto.getX(), palabra.charAt(0)));
    }

    public void cargarIzquierdaDerecha(String palabra) {
        boolean agregado = false;
        MatrizCuadrada<Character> matrizAux;
        Punto punto;
        Character letra;

        while (!agregado) {
            punto = new Punto();
            matrizAux = new MatrizCuadrada<>(SopaDeLetra.TAMANIO);
            matrizAux.copiar(this);

            if (validarIzquierdaDerecha(punto, palabra)) {
                for (int i = punto.getX(); i > punto.getX() - palabra.length(); i--) {
                    letra = palabra.charAt((i - punto.getX()) * (-1));
                    if (!coincidencia(punto.getY(), i, letra)) break;
                    matrizAux.agregar(punto.getY(), i, letra);
                    System.out.println(i+" "+(punto.getX() - palabra.length()));
                    if (i == punto.getX() - palabra.length() + 1) {
                        System.out.println(matrizAux.toString());
                        this.copiar(matrizAux);
                        agregado = true;
                    }
                }
            }
        }
    }

    public boolean validarIzquierdaDerecha(Punto punto, String palabra) {
        if (punto.getX() + 1 - palabra.length() < 0) return false;
        return (coincidencia(punto.getY(), punto.getX(), palabra.charAt(0)));
    }

    public boolean coincidencia(int i, int j, char letra) {
        return (super.dato(i,j) == null || super.dato(i,j) == letra);
    }

    public void completarConLetra() {
        for (int i = 0; i < super.size(); i++) {
            for (int j = 0; j < super.size(); j++) {
                if (super.dato(i,j) == null) super.agregar(i,j,Aleatorio.caracter());
            }
        }
    }
}
