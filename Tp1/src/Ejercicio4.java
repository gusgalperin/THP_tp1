import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio4 {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int num1 = GetNumber();
        int num2 = GetNumber();

        System.out.println(String.format("La suma entre %s y %s da como resultado %s", num1, num2, num1 + num2));

        input.close();
    }

    private static int GetNumber() {
        Integer num = null;

        do
        {

            try {
                System.out.println("Ingrese un número");
                num = input.nextInt();
                input.nextLine();
            }
            catch (InputMismatchException ex) {
                input.nextLine();
                System.out.println("Solo números");
            }

       } while(num == null);

        return num;
    }

}
