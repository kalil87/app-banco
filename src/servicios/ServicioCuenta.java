package servicios;

import entidades.Cuenta;
import entidades.Sucursal;
import repositorios.RepositorioCuenta;
import repositorios.RepositorioSucursal;

import java.util.List;

public class ServicioCuenta {
    private RepositorioCuenta repoC;
    private RepositorioSucursal repoS;

    public ServicioCuenta(RepositorioCuenta repoC, RepositorioSucursal repoS) {
        this.repoC = repoC;
        this.repoS = repoS;
    }

    public void guardarCuenta(Cuenta c) {
        repoC.guardar(c);
    }

    public void guardarSucursal(Sucursal s) {
        repoS.guardar(s);
    }

    public void crearCuenta(Sucursal sucursal, Cuenta cuenta) {

        repoC.guardar(cuenta);

        sucursal.getCuentas().add(cuenta);
    }

    public void eliminarCuenta(String numeroSucursal, String numeroCuenta) {

        Sucursal s = validarSucursal(numeroSucursal);

        Cuenta cuenta = repoC.buscarPorId(numeroCuenta);

        if (cuenta == null) {
            throw new RuntimeException("Cuenta no válida");
        }

        repoC.eliminar(cuenta.getId());
    }

    public Sucursal validarSucursal(String numero) {
        Sucursal s = repoS.buscarPorId(numero);
        if (s == null) {
            throw new RuntimeException("Sucursal no válida");
        }
        return s;
    }

    public Sucursal obtenerSucursal(Cuenta c) {
        if (!repoC.obtenerTodas().contains(c)) {
            throw new RuntimeException("Cuenta no pertenece a la sucursal");
        }
        return c.getSucursal();
    }

    public void validarCuenta(Cuenta c) {
        if (c == null) {
            throw new RuntimeException("Cuenta no permitida");
        }
    }

    public String obtenerIdCuenta(Cuenta cuenta) {
        if (!repoC.obtenerTodas().contains(cuenta)) {
            throw new RuntimeException("Cuenta no pertenece a la sucursal");
        }
        return cuenta.getId();
    }

    public double obtenerSaldo(Cuenta cuenta) {
        if (!repoC.obtenerTodas().contains(cuenta)) {
            throw new RuntimeException("Cuenta no pertenece a la sucursal");
        }
        return cuenta.getSaldo();
    }

    public List<Sucursal> obtenerSucursales(){
        return repoS.obtenerTodas();
    }
}