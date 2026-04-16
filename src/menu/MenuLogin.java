package menu;

import entidades.Usuario;
import servicios.ServicioUsuario;

import java.util.Scanner;

public class MenuLogin {

    public static Usuario iniciar(ServicioUsuario servicioUsuario) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- LOGIN ---");
        System.out.println("EMAIL:");
        String email = sc.nextLine();

        System.out.println("PASSWORD:");
        String password = sc.nextLine();

        return servicioUsuario.login(email, password);
    }
}