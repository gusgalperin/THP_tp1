import Exceptions.SoloMayorACeroException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio7 {

    private static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);

        int[] numeros = GetNumbers(input, 3);

        if(numeros[0] > numeros[1] && numeros[0] > numeros[2])
            MostrarMayor(numeros[0]);
        else if(numeros[1] > numeros[0] && numeros[1] > numeros[2])
            MostrarMayor(numeros[1]);
        else if(numeros[2] > numeros[0] && numeros[2] > numeros[1])
            MostrarMayor(numeros[2]);
        else
            MostrarIguales();

        input.close();
    }

    private static int[] GetNumbers(Scanner input, int count) {
        int[] arr = new int[count];

        Integer num = null;

        for (int i = 0; i < count; i++) {
            do
            {

                try {
                    System.out.println("Ingrese un número");
                    num = input.nextInt();
                }
                catch (InputMismatchException ex) {
                    System.out.println("Solo números");
                }
                finally {
                    input.nextLine();
                }

            } while(num == null);

            arr[i] = num;
        }

        return arr;
    }

    private static void MostrarMayor(int mayor){
        System.out.println(String.format("El mayor es %s", mayor));
    }

    private static void MostrarIguales(){
        System.out.println(String.format("Son iguales"));
    }
}

