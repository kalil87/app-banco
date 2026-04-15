package menu;

import entidades.*;
import servicios.ServicioCuenta;
import servicios.ServicioUsuario;

import java.util.Scanner;

public class MenuAdmin {
    public static void iniciar(ServicioCuenta servicioCuenta, ServicioUsuario servicioUsuario) {
        Scanner sc = new Scanner(System.in);
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
                    System.out.println("Numero de Sucursal:");
                    String numero = sc.nextLine();

                    Sucursal sucursal = servicioCuenta.validarSucursal(numero);

                    Usuario usuarioNuevo = new Usuario("cliente3@mail.com", "1234", Rol.CLIENTE);

                    servicioUsuario.validarUsuario(usuarioNuevo); //por ahora solo valida que no sea null

                    Cuenta cuentaNueva = Cuenta.builder()
                            .id("1")
                            .tipo(TipoCuenta.CA)
                            .saldo(0)
                            .titular(usuarioNuevo)
                            .sucursal(sucursal)
                            .build();

                    servicioCuenta.validarCuenta(cuentaNueva); //por ahora solo valida que no sea null

                    servicioCuenta.crearCuenta(sucursal, cuentaNueva);
                    System.out.println("Se creo la cuenta numero: " + servicioCuenta.obtenerIdCuenta(cuentaNueva));
                }

                case 2 -> {
                    System.out.println("Numero de Sucursal:");
                    String numeroSucursal = sc.nextLine();

                    System.out.println("ID cuenta:");
                    String idCuenta = sc.nextLine();

                    servicioCuenta.eliminarCuenta(numeroSucursal, idCuenta);
                    System.out.println("Se elimino la cuenta numero: " + idCuenta + " de la Sucursal " + numeroSucursal);
                }
            }

        } while (opcion != 0);
    }
}