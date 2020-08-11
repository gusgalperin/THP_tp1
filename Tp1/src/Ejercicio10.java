import Exceptions.InputInvalidoException;
import Exceptions.SoloMayorACeroException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio10 {

    public static void main(String[] args) {
        final int HORA_APERTURA = 10;
        final int HORA_CIERRE = 18;

        int horaIngresada = GetHora();

        System.out.println(String.format(
            "El estacionamiento se encuentra %s",
            horaIngresada >= HORA_APERTURA && horaIngresada <= HORA_CIERRE
                ? "abierto"
                : "cerrado"));
    }

    private static int GetHora() {
        Scanner input = new Scanner(System.in);
        Integer num = null;

        do
        {
            try {
                System.out.println("Ingrese una hora");
                num = input.nextInt();

                if(num < 0 || num > 24) {
                    num = null;
                    throw new InputInvalidoException("El input no es válido");
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("Solo números");
            }
            catch (InputInvalidoException ex) {
                System.out.println("La hora ingresada no es válida");
            }
            finally {
                input.nextLine();
            }

        } while(num == null);

        input.close();

        return num;

    }
}

