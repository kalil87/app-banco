import entidades.*;
import servicios.*;

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

        Cliente c1 = new Cliente("cliente1@mail.com", "1234", "11111111", "Juan Perez");
        Cliente c2 = new Cliente("cliente2@mail.com", "1234", "22222222", "Maria Gomez");

        Admin a1 = new Admin("admin@mail.com", "admin", "A1", "Admin Principal");

        usuarios.add(c1);
        usuarios.add(c2);
        usuarios.add(a1);

        Cuenta cuenta1 = Cuenta.builder()
                .id(1)
                .tipo(TipoCuenta.CA)
                .saldo(0)
                .titular(c1)
                .sucursal(s1)
                .build();

        Cuenta cuenta2 = Cuenta.builder()
                .id(2)
                .tipo(TipoCuenta.CC)
                .saldo(0)
                .titular(c2)
                .sucursal(s2)
                .build();

        c1.setCuenta(cuenta1);
        c2.setCuenta(cuenta2);

        s1.agregarCuenta(cuenta1);
        s2.agregarCuenta(cuenta2);

        ServicioBancario servicioBancario = new ServicioBancario(banco);
        ServicioDeValidacion servicioDeValidacion = new ServicioDeValidacion(usuarios);

        // =========================
        // LOGIN
        // =========================
        System.out.println("EMAIL:");
        String email = sc.nextLine();

        System.out.println("PASSWORD:");
        String password = sc.nextLine();

        Usuario usuario = servicioDeValidacion.login(email, password);

        if (usuario == null) {
            System.out.println("Login incorrecto");
            return;
        }

        System.out.println("Login exitoso");

        // =========================
        // MENU CLIENTE
        // =========================
        if (usuario instanceof Cliente) {

            Cliente cliente = (Cliente) usuario;

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

                        Cuenta cuenta = cliente.getCuenta(); // suponiendo 1 cuenta
                        Sucursal sucursal = cuenta.getSucursal();

                        servicioBancario.depositar(sucursal, cuenta, monto);
                        System.out.println("Se ingresaron: $" + monto);
                        System.out.println("Su saldo actual es de: $" + cuenta.getSaldo());
                    }

                    case 2 -> {
                        System.out.println("Monto:");
                        double monto = sc.nextDouble();

                        Cuenta cuenta = cliente.getCuenta();
                        Sucursal sucursal = cuenta.getSucursal();

                        servicioBancario.retirar(sucursal, cuenta, monto);
                        System.out.println("Se retiraron: $" + monto);
                        System.out.println("Su saldo actual es de: $" + cuenta.getSaldo());
                    }

                    case 3 -> {
                        System.out.println("Monto:");
                        double monto = sc.nextDouble();

                        Cuenta origen = cliente.getCuenta();
                        Sucursal sucOrigen = origen.getSucursal();

                        System.out.println("Cuenta destino:");
                        int idDestino = sc.nextInt();

                        Cuenta destino = buscarCuenta(banco, idDestino);
                        Sucursal sucDestino = destino.getSucursal();

                        servicioBancario.transferir(
                                sucOrigen, origen,
                                sucDestino, destino,
                                monto
                        );
                        System.out.println("Se transfirieron: $" +monto + " a la cuenta " + destino.getId());
                        System.out.println("Su saldo actual es de: $" + origen.getSaldo());
                    }
                }

            } while (opcion != 0);
        }

        // =========================
        // MENU ADMIN
        // =========================
        if (usuario instanceof Admin) {

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
                                .id(1)
                                .tipo(TipoCuenta.CA)
                                .saldo(0)
                                .titular(c1)
                                .sucursal(sucursal)
                                .build();

                        servicioBancario.crearCuenta(sucursal, nueva);
                        System.out.println("Se creo la cuenta numero: " + nueva.getId());
                    }

                    case 2 -> {
                        System.out.println("ID cuenta:");
                        int id = sc.nextInt();

                        Cuenta cuenta = buscarCuenta(banco, id);
                        Sucursal sucursal = cuenta.getSucursal();

                        servicioBancario.eliminarCuenta(sucursal, cuenta);
                        System.out.println("Se elimino la cuenta numero: " + cuenta.getId());
                    }
                }

            } while (opcion != 0);
        }

        sc.close();
    }

    // =========================
    // METODO AUXILIAR
    // =========================
    private static Cuenta buscarCuenta(Banco banco, int id) {

        for (Sucursal s : banco.getSucursales()) {
            for (Cuenta c : s.getCuentas()) {
                if (c.getId() == id) {
                    return c;
                }
            }
        }

        return null;
    }
}