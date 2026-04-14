package servicios;

import entidades.*;

public class ServicioBancario {
    private Banco banco;

    public ServicioBancario(Banco banco) {
        this.banco = banco;
    }

    // =========================
    // CREAR CUENTA
    // =========================
    public void crearCuenta(Sucursal sucursal, Cuenta cuenta) {

        if (!banco.getSucursales().contains(sucursal)) {
            throw new RuntimeException("Sucursal no pertenece al banco");
        }

        sucursal.getCuentas().add(cuenta);
    }

    // =========================
    // ELIMINAR CUENTA
    // =========================
    public void eliminarCuenta(Sucursal sucursal, Cuenta cuenta) {

        if (!sucursal.getCuentas().contains(cuenta)) {
            throw new RuntimeException("La cuenta no pertenece a la sucursal");
        }

        sucursal.getCuentas().remove(cuenta);
    }

    // =========================
    // DEPOSITAR
    // =========================
    public void depositar(Sucursal sucursal, Cuenta cuenta, double monto) {

        validarCuentaEnSucursal(sucursal, cuenta);

        cuenta.setSaldo(cuenta.getSaldo() + monto);
    }

    // =========================
    // RETIRAR
    // =========================
    public void retirar(Sucursal sucursal, Cuenta cuenta, double monto) {

        validarCuentaEnSucursal(sucursal, cuenta);

        if (cuenta.getSaldo() < monto) {
            throw new RuntimeException("Saldo insuficiente");
        }

        cuenta.setSaldo(cuenta.getSaldo() - monto);
    }

    // =========================
    // TRANSFERENCIA
    // =========================
    public void transferir(Sucursal sucOrigen, Cuenta origen,
                           Sucursal sucDestino, Cuenta destino,
                           double monto) {

        validarCuentaEnSucursal(sucOrigen, origen);
        validarCuentaEnSucursal(sucDestino, destino);

        if (origen.getSaldo() < monto) {
            throw new RuntimeException("Saldo insuficiente");
        }

        origen.setSaldo(origen.getSaldo() - monto);
        destino.setSaldo(destino.getSaldo() + monto);
    }

    // =========================
    // VALIDACION CENTRAL
    // =========================
    private void validarCuentaEnSucursal(Sucursal sucursal, Cuenta cuenta) {

        if (!sucursal.getCuentas().contains(cuenta)) {
            throw new RuntimeException("Cuenta no pertenece a la sucursal");
        }
    }
}