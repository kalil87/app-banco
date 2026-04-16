package menu;

import entidades.Cuenta;
import entidades.Sucursal;
import entidades.Usuario;
import servicios.ServicioCuenta;
import servicios.ServicioTransaccion;
import servicios.ServicioUsuario;

import java.util.Scanner;

public class MenuCliente {
    public static void iniciar(Usuario usuario, ServicioUsuario servicioUsuario,
    ServicioCuenta servicioCuenta, ServicioTransaccion servicioTransaccion) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU CLIENTE ---");
            System.out.println("1 Depositar");
            System.out.println("2 Retirar");
            System.out.println("3 Transferir");
            System.out.println("0 Salir");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1 -> {
                    System.out.println("Monto:");
                    double monto = sc.nextDouble();

                    Cuenta cuenta = servicioUsuario.obtenerCuenta(usuario);
                    Sucursal sucursal = servicioCuenta.obtenerSucursal(cuenta);

                    servicioTransaccion.depositar(cuenta, monto);
                    System.out.println("Se ingresaron: $" + monto);
                    System.out.println("Su saldo actual es de: $" + servicioCuenta.obtenerSaldo(cuenta));
                }

                case 2 -> {
                    System.out.println("Monto:");
                    double monto = sc.nextDouble();

                    Cuenta cuenta = servicioUsuario.obtenerCuenta(usuario);
                    Sucursal sucursal = servicioCuenta.obtenerSucursal(cuenta);

                    servicioTransaccion.retirar(cuenta, monto);
                    System.out.println("Se retiraron: $" + monto);
                    System.out.println("Su saldo actual es de: $" + servicioCuenta.obtenerSaldo(cuenta));
                }

                case 3 -> {
                    System.out.println("Monto:");
                    double monto = sc.nextDouble();

                    Cuenta cuenta = servicioUsuario.obtenerCuenta(usuario);
                    Sucursal sucursal = servicioCuenta.obtenerSucursal(cuenta);

                    System.out.println("Cuenta destino numero:");
                    sc.nextLine();
                    String numero = sc.nextLine();

                    Cuenta destino = servicioCuenta.obtenerCuentaPorId(numero);
                    servicioTransaccion.transferir(cuenta, destino, monto);

                    System.out.println("Se transfirieron: $" + monto + " a la cuenta numero " + numero);
                    System.out.println("Su saldo actual es de: $" + servicioCuenta.obtenerSaldo(cuenta));
                }
            }

        } while (opcion != 0);
    }
}