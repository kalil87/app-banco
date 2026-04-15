package app;

import app.config.InicializarDatos;
import entidades.Rol;
import entidades.Usuario;
import menu.MenuAdmin;
import menu.MenuCliente;
import menu.MenuLogin;
import repositorios.RepositorioCuenta;
import repositorios.RepositorioSucursal;
import repositorios.RepositorioUsuario;
import servicios.ServicioCuenta;
import servicios.ServicioTransaccion;
import servicios.ServicioUsuario;

public class App {

    public static void run() {
        RepositorioCuenta repoC = new RepositorioCuenta();
        RepositorioSucursal repoS = new RepositorioSucursal();
        RepositorioUsuario repoU = new RepositorioUsuario();
        ServicioCuenta servicioCuenta = new ServicioCuenta(repoC, repoS);
        ServicioUsuario servicioUsuario = new ServicioUsuario(repoU);
        ServicioTransaccion servicioTransaccion = new ServicioTransaccion();

        InicializarDatos.cargar(servicioCuenta, servicioUsuario);

        Usuario usuario = MenuLogin.iniciar(servicioUsuario);

        if (usuario == null) {
            return;
        }

        if (usuario.getRol() == Rol.ADMIN) {
            MenuAdmin.iniciar(servicioCuenta, servicioUsuario);
        } else if (usuario.getRol() == Rol.CLIENTE) {
            MenuCliente.iniciar(usuario, servicioUsuario, servicioCuenta, servicioTransaccion);
        } else {
            System.out.println("Rol no reconocido");
        }
    }
}