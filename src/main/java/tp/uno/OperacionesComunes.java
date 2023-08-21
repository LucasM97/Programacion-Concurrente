package tp.uno;

public interface OperacionesComunes {
    double INVERSCIONMINIMA = 10000;
    int DIAS = 30;
    int ANIO = DIAS * 12;

    void actualizarAlias(String alias);

    void invertir(double monto, int dias);
}
