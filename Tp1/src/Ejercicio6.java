import Exceptions.SoloMayorACeroException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio6 {

    private static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);

        int num = GetNumber(input);

        System.out.println(String.format("El número %s es %s", num, num % 2 == 0 ? "par" : "impar"));

        input.close();
    }

    private static int GetNumber(Scanner input) {
        Integer num = null;

        do
        {

            try {
                System.out.println("Ingrese un número mayor a 0");
                num = input.nextInt();

                if(num <= 0) {
                    num = null;
                    throw new SoloMayorACeroException();
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("Solo números");
            }
            catch (SoloMayorACeroException ex) {
                System.out.println("Solo números mayores a cero");
            }
            finally {
                input.nextLine();
            }

       } while(num == null);

        return num;
    }

}

