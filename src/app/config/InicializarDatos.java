package app.config;

import entidades.*;
import repositorios.RepositorioCuenta;
import repositorios.RepositorioSucursal;

import java.util.ArrayList;
import java.util.List;

public class InicializarDatos {
    public static DatosIniciales cargar(RepositorioCuenta repoC, RepositorioSucursal repoS) {

        List<Usuario> usuarios = new ArrayList<>();
        List<Sucursal> sucursales = new ArrayList<>();

        Banco banco = Banco.getInstance("Banco", "Argentina");

        // sucursales
        Sucursal s1 = new Sucursal("001", "Centro");
        Sucursal s2 = new Sucursal("002", "Palermo");

        sucursales.add(s1);
        sucursales.add(s2);

        repoS.guardar(s1);
        repoS.guardar(s2);

        banco.setSucursales(sucursales);

        // usuarios
        Usuario u1 = new Usuario("cliente1@mail.com", "1234", Rol.CLIENTE);
        Usuario u2 = new Usuario("cliente2@mail.com", "1234", Rol.CLIENTE);
        Usuario a1 = new Usuario("admin1@mail.com", "admin", Rol.ADMIN);

        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(a1);

        // cuentas
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

        repoC.guardar(c1);
        repoC.guardar(c2);

        return new DatosIniciales(banco, usuarios, sucursales);
    }
}