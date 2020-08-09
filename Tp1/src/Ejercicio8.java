import Exceptions.InputInvalidoException;
import Exceptions.SoloMayorACeroException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio8 {

    public static void main(String[] args) {

        String[] dias = {"Domingo", "Lunes", "Martes", "Miercoles","Jueves","Viernes", "Sabado"};

        int numDia = GetNumber();

        System.out.println(String.format("El día número %s corresponde al %s", numDia, dias[numDia - 1]));
    }

    private static int GetNumber() {
        Scanner input = new Scanner(System.in);
        Integer num = null;

        do
        {
            try {
                System.out.println("Ingrese un número entre 1 y 7");
                num = input.nextInt();

                if(num < 1 || num > 7) {
                    num = null;
                    throw new InputInvalidoException("El input no es válido");
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("Solo números");
            }
            catch (InputInvalidoException ex) {
                System.out.println("El día ingresado no es válido");
            }
            finally {
                input.nextLine();
            }

        } while(num == null);

        input.close();

        return num;
    }
}

