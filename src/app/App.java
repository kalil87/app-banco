package app;

import app.config.InicializarDatos;
import repositorios.RepositorioCuenta;
import repositorios.RepositorioSucursal;
import repositorios.RepositorioUsuario;
import servicios.ServicioBanco;
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
        ServicioBanco servicioBanco = new ServicioBanco(repoS);
        ServicioTransaccion servicioTransaccion = new ServicioTransaccion();

        InicializarDatos.cargar(servicioCuenta, servicioUsuario);

        while (true) {
            NavegadorMenus.iniciar(servicioUsuario, servicioCuenta, servicioTransaccion, servicioBanco);
        }
    }
}