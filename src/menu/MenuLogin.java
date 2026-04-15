package menu;

import entidades.Usuario;
import servicios.ServicioDeValidacion;

import java.util.List;
import java.util.Scanner;

public class MenuLogin {

    public static Usuario iniciar(List<Usuario> usuarios) {
        Scanner sc = new Scanner(System.in);
        ServicioDeValidacion servicioDeValidacion = new ServicioDeValidacion(usuarios);

        System.out.println("EMAIL:");
        String email = sc.nextLine();

        System.out.println("PASSWORD:");
        String password = sc.nextLine();

        Usuario usuario = servicioDeValidacion.login(email, password);

        if (usuario == null) {
            System.out.println("Login incorrecto");
            return null;
        }

        System.out.println("Login exitoso");
        return usuario;
    }
}