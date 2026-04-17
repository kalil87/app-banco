package servicios;

import entidades.Cuenta;
import entidades.Sucursal;
import repositorios.RepositorioCuenta;
import repositorios.RepositorioSucursal;

public class ServicioSucursal {
    private RepositorioSucursal repoS;
    private RepositorioCuenta repoC;

    public ServicioSucursal(RepositorioSucursal repoS, RepositorioCuenta repoC) {
        this.repoS = repoS;
        this.repoC = repoC;
    }

    public void cambiarSucursal(String idCuenta, String numeroSucursalDestino) {

        Cuenta cuenta = repoC.buscarPorId(idCuenta);

        if (cuenta == null) {
            throw new RuntimeException("Cuenta no encontrada");
        }

        Sucursal sucursalDestino = repoS.buscarPorId(numeroSucursalDestino);

        if (sucursalDestino == null) {
            throw new RuntimeException("Sucursal destino no válida");
        }

        Sucursal sucursalOrigen = cuenta.getSucursal();

        sucursalOrigen.getCuentas().remove(cuenta);

        sucursalDestino.getCuentas().add(cuenta);

        cuenta.setSucursal(sucursalDestino);
    }
}
