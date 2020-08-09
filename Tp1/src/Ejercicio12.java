import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int cantidadDados = 3;
        int cantidadDeSeis = 0;

        int[] dados = new int[cantidadDados];

        for (int i = 0; i < cantidadDados; i++) {
            dados[i] = GetIntInput(scanner, String.format("Dado %s: ", i+1), 1, 6);

            if(dados[i] == 6)
                cantidadDeSeis++;
        }

        scanner.close();

        switch (cantidadDeSeis){
            case 1:
                System.out.println("Regular");
                break;
            case 2:
                System.out.println("Muy bien");
                break;
            case 3:
                System.out.println("Excelente");
                break;
            default:
                System.out.println("Insuficiente");
        }
    }

    private static int GetIntInput(Scanner scanner, String mensaje, int greaterThan, int lessThan){
        Integer num = null;

        do
        {
            try {
                System.out.println(mensaje);
                num = scanner.nextInt();

                if(num<greaterThan || num>lessThan){
                    System.out.println(String.format("Ingrese un número entre %s y %s", greaterThan, lessThan));
                    num=null;
                }
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

