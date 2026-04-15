package servicios;

import entidades.Cuenta;
import entidades.Sucursal;
import repositorios.RepositorioCuenta;
import repositorios.RepositorioSucursal;

public class ServicioCuenta {
    private RepositorioCuenta repoC;
    private RepositorioSucursal repoS;

    public ServicioCuenta(RepositorioCuenta repoC, RepositorioSucursal repoS) {
        this.repoC = repoC;
        this.repoS = repoS;
    }

    public void crearCuenta(Sucursal sucursal, Cuenta cuenta) {

        if (!repoS.obtenerTodas().contains(sucursal)) {
            throw new RuntimeException("Sucursal no pertenece al banco");
        }

        sucursal.getCuentas().add(cuenta);
    }

    public void eliminarCuenta(String numeroSucursal, String numeroCuenta) {

        Sucursal sucursal = repoS.buscarPorId(numeroSucursal);

        if (sucursal == null) {
            throw new RuntimeException("Sucursal no válida");
        }

        Cuenta cuenta = repoC.buscarPorId(numeroCuenta);

        if (cuenta == null) {
            throw new RuntimeException("Cuenta no válida");
        }

        repoC.eliminar(cuenta.getId());
    }
}