package app;

import entidades.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // =========================
        // SIMULACION
        // =========================
        Scanner sc = new Scanner(System.in);
        List<Sucursal> sucursales = new ArrayList<>();
        List<Usuario> usuarios = new ArrayList<>();
        Banco banco = Banco.getInstance("Banco", "Argentina");
        Sucursal s1 = new Sucursal("001", "Centro");
        Sucursal s2 = new Sucursal("002", "Palermo");

        sucursales.add(s1);
        sucursales.add(s2);

        banco.setSucursales(sucursales);

        Usuario u1 = new Usuario("cliente1@mail.com", "1234", Rol.CLIENTE);
        Usuario u2 = new Usuario("cliente2@mail.com", "1234", Rol.CLIENTE);
        Usuario a1 = new Usuario("admin1@mail.com", "admin", Rol.ADMIN);

        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(a1);

        Cuenta cuenta1 = Cuenta.builder()
                .id("1")
                .tipo(TipoCuenta.CA)
                .saldo(0)
                .titular(u1)
                .sucursal(s1)
                .build();

        Cuenta cuenta2 = Cuenta.builder()
                .id("2")
                .tipo(TipoCuenta.CC)
                .saldo(0)
                .titular(u2)
                .sucursal(s2)
                .build();

        u1.setCuenta(cuenta1);
        u2.setCuenta(cuenta2);

        s1.agregarCuenta(cuenta1);
        s2.agregarCuenta(cuenta2);

        App.run(usuarios, banco, sucursales);
    }
}