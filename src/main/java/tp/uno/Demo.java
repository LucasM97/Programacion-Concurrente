package tp.uno;

import static java.lang.System.*;

public class Demo {
    public static void main(String[] args) {
        Cuenta c1 = new Cuenta(Aleatorio.dni(),
                               Aleatorio.monto(20000, 30000),
                               Aleatorio.interes());

        CuentaSueldo c2 = new CuentaSueldo(Aleatorio.dni(),
                                           Aleatorio.monto(20000, 50000),
                                           Aleatorio.interes(),
                                           Aleatorio.legajo(),
                                           Aleatorio.institucion(),
                                           Aleatorio.beneficio(),
                                           Aleatorio.cbu());

        CuentaSueldo c3 = new CuentaSueldo(Aleatorio.dni(),
                                           Aleatorio.monto(20000, 50000),
                                           Aleatorio.interes(),
                                           Aleatorio.legajo(),
                                           Aleatorio.institucion(),
                                           Aleatorio.beneficio(),
                                           Aleatorio.cbu());

        out.println(c1);
        out.println(c2);
        out.println(c3);

        c1.ingresar(Aleatorio.monto(20000, 30000));

        c1.ingresar(Aleatorio.monto(20000, 30000));

        c1.retirar(Aleatorio.monto(15000, 25000));

        out.println(c1);

        c3.retirar(Aleatorio.monto(10000, 20000));

        out.println(c3);
    }
}
