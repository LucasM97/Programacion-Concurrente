package tp.dos;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        //Ejercicio 1
        System.out.println("############### Matriz con Diagonal Principal igual a 1 ###############");

        MatrizCuadrada<Integer> diagonal = new DiagonalPrincipal();

        System.out.println(diagonal);

        //Ejercicio 3
        System.out.println("################## Movimiento del Caballo en Ajedrez ##################");
        int x, y;

        x = ingresarEntero("Ingrese posicion en x (entre 1 y 10)");

        y = ingresarEntero("Ingrese posicion en y (entre 1 y 10)");

        MatrizCuadrada<String> tablero = new TableroAjedrez(x,y);

        //Ejercicio 6
        System.out.println("\n###################### Patron de relog de arena #######################");
        MatrizCuadrada<Character> figura = new Patron(6);

        System.out.println(figura);
    }

    public static int ingresarEntero(String mensaje) {
        int dato;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("\n" + mensaje + "\n");
                dato = scanner.nextInt();
                if (dato < 11 && dato > 0) return dato;
                else System.out.println("\nERROR: El valor ingresado no es valido\n");
            } catch (Exception e) {
                System.out.println("\nERROR: El valor ingresado no es valido\n");
                scanner.nextLine();
            }
        }
    }
}
