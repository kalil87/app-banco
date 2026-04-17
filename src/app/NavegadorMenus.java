package app;

import entidades.Rol;
import entidades.Usuario;
import menu.MenuAdmin;
import menu.MenuCliente;
import menu.MenuLogin;
import servicios.*;

public class NavegadorMenus {

    public static void iniciar(
            ServicioUsuario servicioUsuario,
            ServicioCuenta servicioCuenta,
            ServicioTransaccion servicioTransaccion,
            ServicioBanco servicioBanco,
            ServicioSucursal servicioSucursal) {

        Usuario usuario = MenuLogin.iniciar(servicioUsuario);

        if (usuario == null) {
            return;
        }

        if (usuario.getRol() == Rol.ADMIN) {
            MenuAdmin.iniciar(servicioCuenta, servicioUsuario, servicioBanco, servicioSucursal);
        } else if (usuario.getRol() == Rol.CLIENTE) {
            MenuCliente.iniciar(usuario, servicioUsuario, servicioCuenta, servicioTransaccion);
        } else {
            System.out.println("Rol no reconocido");
        }
    }
}