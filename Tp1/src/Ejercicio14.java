import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio14 {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        char operacion = GetOperacion(scanner);

        while (operacion != 'e'){
            int primerNumero = GetIntInput(scanner, "Ingrese primer número", null);
            int segundoNumero = GetIntInput(scanner, "Ingrese segundo numero", operacion == 'd' ? 0 : null);

            switch (operacion){
                case 's':
                    MostrarResultado(primerNumero + segundoNumero);
                    break;
                case 'r':
                    MostrarResultado(primerNumero - segundoNumero);
                    break;
                case 'p':
                    MostrarResultado(primerNumero * segundoNumero);
                    break;
                case 'd':
                    MostrarResultado((double) primerNumero / segundoNumero);
                    break;
                default:
                    throw new Exception("operación inválida: " + operacion);
            }

            operacion = GetOperacion(scanner);
        }

        scanner.close();
    }

    private static char GetOperacion(Scanner scanner){
        char operacion = 'n';

        do
        {
            System.out.println("Ingrese operacion arítmetica: ('s'/'r'/'p'/'d') - 'e' para salir");

            operacion = scanner.next().charAt(0);

            operacion = Character.toLowerCase(operacion);

        } while(!IsValidOperacion(operacion));

        return operacion;
    }

    private static boolean IsValidOperacion(char op){
        return op == 's' || op == 'r' || op == 'p' || op == 'd' || op == 'e';
    }

    private static int GetIntInput(Scanner scanner, String mensaje, Integer notEqual){
        Integer num = null;

        do
        {
            try {
                System.out.println(mensaje);
                num = scanner.nextInt();

                if(notEqual != null && num == notEqual){
                    System.out.println(String.format("Ingrese un número disntito a %s", notEqual));
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

    private static void MostrarResultado(int resultado){
        System.out.println(String.format("Resultado: %s", resultado));
    }

    private static void MostrarResultado(double resultado){
        System.out.println(String.format("Resultado: %s", resultado));
    }

}

