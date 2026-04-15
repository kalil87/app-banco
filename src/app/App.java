package app;

import app.config.DatosIniciales;
import app.config.InicializarDatos;
import entidades.Rol;
import entidades.Usuario;
import menu.MenuAdmin;
import menu.MenuCliente;
import menu.MenuLogin;
import repositorios.RepositorioCuenta;
import repositorios.RepositorioSucursal;

public class App {

    public static void run() {
        RepositorioCuenta repoC = new RepositorioCuenta();
        RepositorioSucursal repoS = new RepositorioSucursal();
        DatosIniciales datos = InicializarDatos.cargar(repoC, repoS);

        Usuario usuario = MenuLogin.iniciar(datos.getUsuarios());

        if (usuario == null) {
            System.out.println("Error al iniciar sesión");
            return;
        }

        if (usuario.getRol() == Rol.ADMIN) {
            MenuAdmin.iniciar(usuario,datos.getBanco(), datos.getSucursales(), repoC, repoS);
        } else if (usuario.getRol() == Rol.CLIENTE) {
            MenuCliente.iniciar(usuario, datos.getBanco());
        } else {
            System.out.println("Rol no reconocido");
        }
    }
}