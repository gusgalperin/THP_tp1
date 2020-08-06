import Exceptions.NoSeAceptaCeroException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio5 {

    private static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);

        int num1 = GetNumber(input, true);
        int num2 = GetNumber(input, false);

        double resultado = (double)num1 / num2;

        System.out.println(String.format("La división entre %s y %s da como resultado %s", num1, num2, resultado));

        input.close();
    }

    private static int GetNumber(Scanner input, boolean aceptarCero) {
        Integer num = null;

        do
        {

            try {
                System.out.println("Ingrese un número");
                num = input.nextInt();

                if(!aceptarCero && num == 0) {
                    num = null;
                    throw new NoSeAceptaCeroException();
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("Solo números");
            }
            catch (NoSeAceptaCeroException ex) {
                System.out.println("No se puede dividir por cero");
            }
            finally {
                input.nextLine();
            }

       } while(num == null);

        return num;
    }

}

