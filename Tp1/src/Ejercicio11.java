import Exceptions.InputInvalidoException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio11 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String fechaCompra = GetStringInput("Ingrese fecha de compra (YYYYMMDD)");
        String nombreComprador = GetStringInput("Ingrese nombre del comprador");
        String nombreProducto = GetStringInput("Ingrese nombre del producto");
        int cantidad = GetIntInput("Ingrese cantidad", 0);
        double precio = GetDoubleInput("Ingrese precio", 0);

        scanner.close();

        System.out.println(String.format("Fecha de Compra: %s", fechaCompra));
        System.out.println(String.format("Nombre del Comprador:  %s", nombreComprador));
        System.out.println(String.format("Producto solicitado: %s", nombreProducto));
        System.out.println(String.format("Cantidad solicitada: %s", cantidad));
        System.out.println(String.format("Precio Unitario: $%s", precio));
        System.out.println(String.format("Total a Pagar:  $%s", cantidad * precio));
    }

    private static String GetStringInput(String mensaje) {
        String input = "";

        do
        {
            System.out.println(mensaje);

            input = scanner.nextLine();

        } while(input == null || input.isEmpty());

        return input;
    }

    private static int GetIntInput(String mensaje, int greaterThan){
        Integer num = null;

        do
        {
            try {
                System.out.println(mensaje);
                num = scanner.nextInt();
            }
            catch (InputMismatchException ex) {
                System.out.println("Solo números");
            }
            finally {
                scanner.nextLine();
            }

        } while(num == null || num <= greaterThan);

        return num;
    }

    private static double GetDoubleInput(String mensaje, double greaterThan){
        Double num = null;

        do
        {
            try {
                System.out.println(mensaje);
                num = scanner.nextDouble();
            }
            catch (InputMismatchException ex) {
                System.out.println("Solo números");
            }
            finally {
                scanner.nextLine();
            }

        } while(num == null|| num <= greaterThan);

        return num;
    }

    /*private static <T> T GetInput(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        Class<T> input=null;

        do
        {
            try {
                System.out.println(mensaje);

                switch (input){

                }

                num = scanner.nextInt();

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
                scanner.nextLine();
            }

        } while(num == null);

        scanner.close();

        return num;

    }*/
}

