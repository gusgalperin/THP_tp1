import java.util.Scanner;

public class Ejercicio3 {

    private static Scanner input;

    public static void main(String[] args) {
        System.out.println("Bienvenido: " + GetUserName());
    }

    private static String GetUserName() {
        String nombre;
        input = new Scanner(System.in);

        do {
            System.out.println("Ingrese su nombre");
            nombre = input.nextLine();
        } while (nombre == null || nombre.isEmpty());

        input.close();

        return nombre;
    }

}
