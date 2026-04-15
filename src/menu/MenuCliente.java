package menu;

import entidades.Banco;
import entidades.Cuenta;
import entidades.Sucursal;
import entidades.Usuario;
import servicios.ServicioTransaccion;

import java.util.Scanner;

public class MenuCliente {
    public static void iniciar(Usuario usuario, Banco banco) {
        ServicioTransaccion servicioTransaccion = new ServicioTransaccion();
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

                    Cuenta cuenta = usuario.getCuenta();
                    Sucursal sucursal = cuenta.getSucursal();

                    servicioTransaccion.depositar(sucursal, cuenta, monto);
                    System.out.println("Se ingresaron: $" + monto);
                    System.out.println("Su saldo actual es de: $" + cuenta.getSaldo());
                }

                case 2 -> {
                    System.out.println("Monto:");
                    double monto = sc.nextDouble();

                    Cuenta cuenta = usuario.getCuenta();
                    Sucursal sucursal = cuenta.getSucursal();

                    servicioTransaccion.retirar(sucursal, cuenta, monto);
                    System.out.println("Se retiraron: $" + monto);
                    System.out.println("Su saldo actual es de: $" + cuenta.getSaldo());
                }

                case 3 -> {
                    System.out.println("Monto:");
                    double monto = sc.nextDouble();

                    Cuenta origen = usuario.getCuenta();
                    Sucursal sucOrigen = origen.getSucursal();

                    System.out.println("Cuenta destino:");
                    sc.nextLine();
                    String cbuDestino = sc.nextLine();

                    servicioTransaccion.transferir(
                            sucOrigen, origen,
                             cbuDestino,
                            monto
                    );
                    System.out.println("Se transfirieron: $" + monto + " a la cuenta con CBU " + cbuDestino);
                    System.out.println("Su saldo actual es de: $" + origen.getSaldo());
                }
            }

        } while (opcion != 0);
    }
}