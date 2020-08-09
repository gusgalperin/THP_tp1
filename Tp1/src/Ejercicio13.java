import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double valorHoraSimple = 16;
        final double valorHoraExtra = 20;
        final int cantidadHorasBaseSemanal = 40;

        int horasTrabajadas = GetIntInput(scanner, "Ingrese cantidad de horas trabajas", 0);

        int horasExtra = horasTrabajadas - cantidadHorasBaseSemanal;

        if(horasExtra > 0){
            double salarioExtra = horasExtra * valorHoraExtra;
            double salarioSimple = cantidadHorasBaseSemanal * valorHoraSimple;

            System.out.println(String.format("%s horas extra: $%s", horasExtra, salarioExtra));
            System.out.println(String.format("%s horas regulares: $%s", cantidadHorasBaseSemanal, salarioSimple));

            System.out.println(String.format("Total por %s horas trabajadas: $%s", horasTrabajadas, salarioSimple + salarioExtra));
        }
        else{
            System.out.println(String.format("Total por %s horas trabajadas: $%s", horasTrabajadas, horasTrabajadas * valorHoraSimple));
        }

        scanner.close();
    }

    private static int GetIntInput(Scanner scanner, String mensaje, int greaterThan){
        Integer num = null;

        do
        {
            try {
                System.out.println(mensaje);
                num = scanner.nextInt();

                if(num<greaterThan){
                    System.out.println(String.format("Ingrese un número mayor a %s", greaterThan));
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

