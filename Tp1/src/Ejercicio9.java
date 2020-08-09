import Exceptions.InputInvalidoException;
import Exceptions.SoloMayorACeroException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio9 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int cantidad = 3;

        String[] nombres = GetNombresAportantes(input, cantidad);
        Double[] montos = GetMontos(input, nombres);

        Double total = montos[0] + montos[1] + montos[2];

        for (int i = 0; i < cantidad; i++) {
            System.out.println(String.format("%s aportó $%s que representa un %%%s del total: %s", nombres[i], montos[i], (montos[i]*100)/total, total));
        }

        input.close();
    }

    private static String[] GetNombresAportantes(Scanner input, int cant){
        String[] arr = new String[cant];

        for (int i = 0; i < cant; i++) {
            String nombre;

            do {
                System.out.println(String.format("Ingrese el nombre del aportante %s", i + 1));
                nombre = input.nextLine();
            } while (nombre == null || nombre.isEmpty());

            arr[i] = nombre;
        }

        return arr;
    }

    private static Double[] GetMontos(Scanner input, String[] nombres) {
        Double[] montos = new Double[nombres.length];

        for (int i = 0; i < nombres.length; i++) {

            Double num = null;

            do {
                try {
                    System.out.println(String.format("Ingrese cuanto aporta %s", nombres[i]));
                    num = input.nextDouble();

                    if (num < 0) {
                        num = null;
                        throw new SoloMayorACeroException();
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Solo números");
                } catch (SoloMayorACeroException ex) {
                    System.out.println("El monto no puede ser negativo");
                } finally {
                    input.nextLine();
                }

            } while (num == null);

            montos[i] = num;
        }

        return montos;

    }
}

