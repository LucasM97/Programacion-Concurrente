package tp.cinco.dos;

public class Producto {

    public String nombre;
    public int numero;

    public Producto(String nombre, int numero) {
        setNombre(nombre);
        setNumero(numero);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
