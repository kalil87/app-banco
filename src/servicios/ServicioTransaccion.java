package servicios;

import entidades.Cuenta;
import entidades.Sucursal;

public class ServicioTransaccion {

    public void depositar(Sucursal sucursal, Cuenta cuenta, double monto) {

        validarCuentaEnSucursal(sucursal, cuenta);

        cuenta.setSaldo(cuenta.getSaldo() + monto);
    }

    public void retirar(Sucursal sucursal, Cuenta cuenta, double monto) {

        validarCuentaEnSucursal(sucursal, cuenta);

        if (cuenta.getSaldo() < monto) {
            throw new RuntimeException("Saldo insuficiente");
        }

        cuenta.setSaldo(cuenta.getSaldo() - monto);
    }

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

    private void validarCuentaEnSucursal(Sucursal sucursal, Cuenta cuenta) {

        if (!sucursal.getCuentas().contains(cuenta)) {
            throw new RuntimeException("Cuenta no pertenece a la sucursal");
        }
    }
}
