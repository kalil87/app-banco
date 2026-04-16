package app.config;

import entidades.*;
import servicios.ServicioCuenta;
import servicios.ServicioUsuario;

public class InicializarDatos {
    public static void cargar(ServicioCuenta servicioC, ServicioUsuario servicioU) {

        Banco banco = Banco.getInstance("Banco", "Argentina");
        banco.setSucursales(servicioC.obtenerSucursales());

        Sucursal s1 = new Sucursal("001", "Centro");
        Sucursal s2 = new Sucursal("002", "Palermo");

        servicioC.guardarSucursal(s1);
        servicioC.guardarSucursal(s2);

        Usuario u1 = new Usuario("cliente1@mail.com", "1234", Rol.CLIENTE);
        Usuario u2 = new Usuario("cliente2@mail.com", "1234", Rol.CLIENTE);
        Usuario a1 = new Usuario("admin1@mail.com", "admin", Rol.ADMIN);

        servicioU.guardar(u1);
        servicioU.guardar(u2);
        servicioU.guardar(a1);

        Cuenta c1 = Cuenta.builder()
                .id("1")
                .tipo(TipoCuenta.CA)
                .saldo(0)
                .titular(u1)
                .sucursal(s1)
                .build();

        Cuenta c2 = Cuenta.builder()
                .id("2")
                .tipo(TipoCuenta.CC)
                .saldo(0)
                .titular(u2)
                .sucursal(s2)
                .build();

        u1.setCuenta(c1);
        u2.setCuenta(c2);

        s1.agregarCuenta(c1);
        s2.agregarCuenta(c2);

        servicioC.guardarCuenta(c1);
        servicioC.guardarCuenta(c2);
    }
}