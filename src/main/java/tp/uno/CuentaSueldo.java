package tp.uno;

public class CuentaSueldo extends Cuenta{
    private final int LEGAJO;
    private String institucion, beneficios;
    private final long CBU;
    private final double TOPE;

    //region Constructores
    public CuentaSueldo() {
        this(0,0,0,0,"","",0,0);
    }

    public CuentaSueldo(long cbu) {
        this(0,0,0,0,"","",cbu,15000);
    }

    public CuentaSueldo(long dni, double saldo, double interes, int legajo, String institucion, String beneficios, long cbu) {
        this(dni, saldo, interes, legajo, institucion, beneficios, cbu, 15000);
    }

    public CuentaSueldo(long dni, double saldo, double interes, int legajo, String institucion, String beneficios, long cbu, double tope) {
        super(dni,saldo,interes);
        this.LEGAJO = legajo;
        setInstitucion(institucion);
        setBeneficios(beneficios);
        this.CBU = cbu;
        this.TOPE = tope;
    }
    //endregion

    @Override
    public void retirar(double monto) {
        if(haySaldo(monto) && getSaldo() >= getTOPE()) {
            setSaldo(getSaldo() - monto);
            avisoSaldo("Retiro de " + monto + "$ exitoso");
        } else avisoSaldo("No se pudo retirar " + monto + "$. Saldo insuficiente");
    }

    public void trasferir(double monto, long cbu) {
        if(haySaldo(monto) && getSaldo() <= getTOPE()) {
            setSaldo(getSaldo() - monto);
            avisoSaldo("Se tranfirio " + monto + "$ a CBU: " + cbu);
        } else avisoSaldo("Saldo insuficiente o exede el tope de " + getTOPE());
    }

    //region Getters and Setters
    public int getLegajo() {
        return this.LEGAJO;
    }

    public String getInstitucion() {
        return this.institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getBeneficios() {
        return this.beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public long getCBU() {
        return this.CBU;
    }

    public double getTOPE() {
        return this.TOPE;
    }

    //endregion

    @Override
    public String toString() {
        return String.format("%n######### Datos de la cuenta #########%n" +
                        "N° de cuenta: %d%n" +
                        "DNI: %d%n" +
                        "Interes anual: %.2f%%%n" +
                        "Legajo: %d%n" +
                        "Institución: %s%n" +
                        "Beneficios: %s%n" +
                        "CBU: %d%n" +
                        "Saldo: %.2f%n" +
                        "Tope de retiro: %.2f%n" +
                        "######################################",
                         getNumeroCuenta(),getDNI(),getINTERESANUAL(),getLegajo(),getInstitucion(),getBeneficios(),getCBU(),getSaldo(),getTOPE());
    }
}
