package menu;

import entidades.*;
import repositorios.RepositorioCuenta;
import repositorios.RepositorioSucursal;
import servicios.ServicioCuenta;

import java.util.List;
import java.util.Scanner;

public class MenuAdmin {
    public static void iniciar(Usuario usuario, Banco banco, List<Sucursal> sucursales,
    RepositorioCuenta repoC, RepositorioSucursal repoS) {
        Scanner sc = new Scanner(System.in);
        ServicioCuenta servicioCuenta = new ServicioCuenta(repoC, repoS);
        int opcion;

        do {
            System.out.println("\n--- MENU ADMIN ---");
            System.out.println("1 Crear cuenta");
            System.out.println("2 Eliminar cuenta");
            System.out.println("0 Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1 -> {
                    // ejemplo simple para no ingresar mucho en teclado
                    System.out.println("Crear cuenta (simulado)");

                    Sucursal sucursal = sucursales.get(0);

                    Cuenta nueva = Cuenta.builder()
                            .id("1")
                            .tipo(TipoCuenta.CA)
                            .saldo(0)
                            .titular(usuario)
                            .sucursal(sucursal)
                            .build();

                    servicioCuenta.crearCuenta(sucursal, nueva);
                    System.out.println("Se creo la cuenta numero: " + nueva.getId());
                }

                case 2 -> {
                    System.out.println("Numero de Sucursal:");
                    String numero = sc.nextLine();

                    System.out.println("ID cuenta:");
                    String id = sc.nextLine();

                    servicioCuenta.eliminarCuenta(numero, id);
                    System.out.println("Se elimino la cuenta numero: " + id + " de la Sucursal " + numero);
                }
            }

        } while (opcion != 0);
    }
}