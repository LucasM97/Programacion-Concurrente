package tp.uno;

import static java.lang.System.*;

public class Cuenta {
    private static long auxNumeroCuenta = 100000;
    private long numeroCuenta;
    private final long DNI;
    private double saldo;
    private final double INTERESANUAL;

    //region Constructores
    public Cuenta() {
        this(0,0,0);
    }

    public Cuenta(long dni, double saldo, double interes) {
        this.DNI = dni;
        this.INTERESANUAL = interes;
        setSaldo(saldo);
        actualizarNumeroCuenta();
    }
    //endregion

    public void actualizarSaldo() {
        setSaldo(getSaldo()*(1+(getINTERESANUAL()/100)/365));
    }

    public void ingresar(double monto) {
        setSaldo(getSaldo() + monto);
        avisoSaldo("Se ingreso " + monto + "$");
    }

    public void retirar(double monto) {
        if(haySaldo(monto)) {
            setSaldo(getSaldo() - monto);
            avisoSaldo("Retiro de " + monto + "$ exitoso");
        } else avisoSaldo("No se pudo retirar " + monto + "$. Saldo insuficiente");
    }

    private void actualizarNumeroCuenta() {
        setNumeroCuenta(++auxNumeroCuenta);
    }

    public boolean haySaldo(double monto) {
        return getSaldo() >= monto;
    }

    public void avisoSaldo(String mensaje) {
        out.printf("%nN° de Cuenta: %d%n%s%nSaldo: %.2f$%n",getNumeroCuenta(),mensaje,getSaldo());
    }

    //region Getters and Setters
    public long getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public void setNumeroCuenta(long numero) {
        this.numeroCuenta = numero;
    }

    public long getDNI() {
        return this.DNI;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getINTERESANUAL() {
        return this.INTERESANUAL;
    }
    //endregion

    @Override
    public String toString() {
        return String.format("%n######### Datos de la cuenta #########%n" +
                             "N° de cuenta: %d%n" +
                             "DNI: %d%n" +
                             "Saldo: %.2f$%n" +
                             "Interes anual: %.2f%%%n" +
                             "######################################",
                              getNumeroCuenta(),getDNI(),getSaldo(),getINTERESANUAL());
    }
}