package tp.dos;

public class Demo {
    public static void main(String[] args) {
        //Ejercicio 1
        System.out.println("############### Matriz con Diagonal Principal igual a 1 ###############");

        MatrizCuadrada<Integer> diagonal = new DiagonalPrincipal();

        System.out.println(diagonal);

        //Ejercicio 3
        System.out.println("################## Movimiento del Caballo en Ajedrez ##################");

        MatrizCuadrada<String> tablero = new TableroAjedrez(2,4);

        //Ejercicio 6
        System.out.println("\n###################### Patron de relog de arena #######################");
        MatrizCuadrada<Character> figura = new Patron(6);

        System.out.println(figura);
    }
}
