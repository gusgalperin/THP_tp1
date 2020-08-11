import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio15 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        int operacion = MostrarMenu();

        while (operacion != -1){
            switch(operacion){
                case 1:
                    int numero = GetIntInput("Ingrese un numero");
                    CalcularYMostrarResultado(numero);
                    break;
                case 2:
                    int[] numerosDePrueba = {-2, 0, 3, 4, 10, 13, 26};
                    for (int i = 0; i < numerosDePrueba.length; i++) {
                        System.out.println(String.format("Numero de prueba: %s", numerosDePrueba[i]));
                        CalcularYMostrarResultado(numerosDePrueba[i]);
                        System.out.println("-------");
                    }
            }

            operacion = MostrarMenu();
        }

        scanner.close();
    }

    private static int MostrarMenu(){
        Integer operacion;

        do
        {
            System.out.println("Ingrese opción:");
            System.out.println("1. Ingresar por teclado");
            System.out.println("2. Mostrar set de prueba:");
            System.out.println("-1. Salir:");

            operacion = GetIntInput("");

        } while(operacion < -1 || operacion > 2);

        return operacion;
    }

    private static void CalcularYMostrarResultado(int numero){
        boolean estaEnA = false;
        boolean estaEnB = false;
        boolean estaEnAmbos = false;
        boolean noEstaEnNinguno = false;

        if(numero - 10 < 0)
            estaEnA = true;

        if(numero % 2 != 0 )
            estaEnB = true;

        estaEnAmbos = estaEnA && estaEnB;

        noEstaEnNinguno = !estaEnA && !estaEnB;

        System.out.println(String.format("estaEnA (El número es de un solo dígito): %s", estaEnA ));
        System.out.println(String.format("estaEnB (El número es impar): %s", estaEnB));
        System.out.println(String.format("estaEnAmbos: %s", estaEnAmbos));
        System.out.println(String.format("noEstaEnNinguno: %s", noEstaEnNinguno));
    }

    private static int GetIntInput(String mensaje){
        Integer num = null;

        do
        {
            try {
                if(mensaje != null && !mensaje.isEmpty())
                    System.out.println("Ingrese un número");
                num = scanner.nextInt();
            }
            catch (InputMismatchException ex) {
                System.out.println("Solo números");
            }
            finally {
                scanner.nextLine();
            }

        } while(num == null);

        return num;
    }

}

