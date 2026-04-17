package menu;

import entidades.*;
import servicios.ServicioBanco;
import servicios.ServicioCuenta;
import servicios.ServicioSucursal;
import servicios.ServicioUsuario;

import java.util.Scanner;

public class MenuAdmin {
    public static void iniciar(ServicioCuenta servicioCuenta, ServicioUsuario servicioUsuario, ServicioBanco servicioBanco, ServicioSucursal servicioSucursal) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU ADMIN ---");
            System.out.println("1 Crear cuenta");
            System.out.println("2 Eliminar cuenta");
            System.out.println("3 Ver balance global");
            System.out.println("4 Ver balance por sucursal");
            System.out.println("5 Cambiar de sucursal");
            System.out.println("0 Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1 -> {
                    System.out.println("=== Crear cuenta ===");

                    System.out.print("Numero de sucursal: ");
                    String numeroSucursal = sc.nextLine();

                    Sucursal sucursal = servicioCuenta.validarSucursal(numeroSucursal);

                    System.out.print("Email del usuario: ");
                    String email = sc.nextLine();

                    System.out.print("Password: ");
                    String password = sc.nextLine();

                    Usuario usuarioNuevo = servicioUsuario.crearUsuario(email, password);
                    servicioUsuario.validarUsuario(usuarioNuevo);
                    servicioUsuario.guardar(usuarioNuevo);

                    System.out.print("ID de la cuenta: ");
                    String idCuenta = sc.nextLine();

                    System.out.print("Tipo de cuenta (CA/CC): ");
                    String tipo = sc.nextLine();

                    TipoCuenta tipoCuenta = TipoCuenta.valueOf(tipo.toUpperCase());

                    Cuenta cuentaNueva = servicioCuenta.crearCuenta(idCuenta, tipoCuenta, usuarioNuevo, sucursal);

                    servicioUsuario.vincularCuenta(usuarioNuevo, cuentaNueva);

                    System.out.println("Se creó la cuenta número: " + idCuenta);
                }

                case 2 -> {
                    System.out.println("Numero de Sucursal:");
                    String numeroSucursal = sc.nextLine();

                    System.out.println("ID cuenta:");
                    String idCuenta = sc.nextLine();

                    Cuenta cuenta = servicioCuenta.obtenerCuentaPorId(idCuenta);
                    servicioCuenta.eliminarCuenta(cuenta);
                    servicioUsuario.eliminarUsuarioPorCuenta(cuenta);

                    System.out.println("Se elimino la cuenta numero: " + idCuenta + " de la Sucursal " + numeroSucursal);
                }

                case 3 -> {
                    double total = servicioBanco.balanceGlobal();
                    System.out.println("Balance global: " + total);
                }

                case 4 -> {
                    System.out.print("Numero de sucursal: ");
                    String numero = sc.nextLine();

                    double total = servicioBanco.balancePorSucursal(numero);
                    System.out.println("Balance sucursal: " + total);
                }

                case 5 -> {
                    System.out.print("ID cuenta: ");
                    String idCuenta = sc.nextLine();

                    System.out.print("Sucursal destino: ");
                    String destino = sc.nextLine();

                    servicioSucursal.cambiarSucursal(idCuenta, destino);

                    System.out.println("Sucursal actualizada");
                }
            }

        } while (opcion != 0);
    }
}