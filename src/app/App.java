package app;

import entidades.Banco;
import entidades.Rol;
import entidades.Sucursal;
import entidades.Usuario;
import menu.MenuAdmin;
import menu.MenuCliente;
import menu.MenuLogin;

import java.util.List;

public class App {

    public static void run(List<Usuario> usuarios, Banco banco, List<Sucursal> sucursales) {
        Usuario usuario = MenuLogin.iniciar(usuarios);

        if (usuario == null) {
            System.out.println("Error al iniciar sesión");
            return;
        }

        if (usuario.getRol() == Rol.ADMIN) {
            MenuAdmin.iniciar(usuario,banco, sucursales);
        } else if (usuario.getRol() == Rol.CLIENTE) {
            MenuCliente.iniciar(usuario, banco);
        } else {
            System.out.println("Rol no reconocido");
        }
    }
}