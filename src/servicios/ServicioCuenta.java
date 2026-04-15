package servicios;

import entidades.Banco;
import entidades.Cuenta;
import entidades.Sucursal;

public class ServicioCuenta {
    private Banco banco;

    public ServicioCuenta(Banco banco) {
        this.banco = banco;
    }

    public void crearCuenta(Sucursal sucursal, Cuenta cuenta) {

        if (!banco.getSucursales().contains(sucursal)) {
            throw new RuntimeException("Sucursal no pertenece al banco");
        }

        sucursal.getCuentas().add(cuenta);
    }

    public void eliminarCuenta(Sucursal sucursal, Cuenta cuenta) {

        if (!sucursal.getCuentas().contains(cuenta)) {
            throw new RuntimeException("La cuenta no pertenece a la sucursal");
        }

        sucursal.getCuentas().remove(cuenta);
    }
}
