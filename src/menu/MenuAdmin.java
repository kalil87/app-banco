package menu;

import entidades.*;
import servicios.ServicioBancario;

import java.util.List;
import java.util.Scanner;

public class MenuAdmin {
    public static void iniciar(Usuario usuario, Banco banco, List<Sucursal> sucursales) {
        Scanner sc = new Scanner(System.in);
        ServicioBancario servicioBancario = new ServicioBancario(banco);
        int opcion;

        do {
            System.out.println("\n--- MENU ADMIN ---");
            System.out.println("1 Crear cuenta");
            System.out.println("2 Eliminar cuenta");
            System.out.println("0 Salir");

            opcion = sc.nextInt();

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

                    servicioBancario.crearCuenta(sucursal, nueva);
                    System.out.println("Se creo la cuenta numero: " + nueva.getId());
                }

                case 2 -> {
                    System.out.println("ID cuenta:");
                    sc.nextLine();
                    String id = sc.nextLine();

                    Cuenta cuenta = buscarCuenta(banco, id);
                    Sucursal sucursal = cuenta.getSucursal();

                    servicioBancario.eliminarCuenta(sucursal, cuenta);
                    System.out.println("Se elimino la cuenta numero: " + cuenta.getId());
                }
            }

        } while (opcion != 0);
    }

        private static Cuenta buscarCuenta(Banco banco, String id) {

        for (Sucursal s : banco.getSucursales()) {
            for (Cuenta c : s.getCuentas()) {
                if (c.getId().equals(id)) {
                    return c;
                }
            }
        }

        return null;
    }
}