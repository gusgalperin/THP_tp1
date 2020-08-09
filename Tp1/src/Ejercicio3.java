import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        System.out.println("Bienvenido: " + GetUserName());
    }

    private static String GetUserName() {
        Scanner input = new Scanner(System.in);
        String nombre;

        do {
            System.out.println("Ingrese su nombre");
            nombre = input.nextLine();
        } while (nombre == null || nombre.isEmpty());

        input.close();

        return nombre;
    }

}
