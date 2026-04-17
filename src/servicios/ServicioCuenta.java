package servicios;

import entidades.Cuenta;
import entidades.Sucursal;
import entidades.TipoCuenta;
import entidades.Usuario;
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

    public Cuenta crearCuenta(String id, TipoCuenta t, Usuario u, Sucursal s) {

        Cuenta cuenta = Cuenta.builder()
                .id(id)
                .tipo(t)
                .saldo(0)
                .titular(u)
                .sucursal(s)
                .build();

        validarCuenta(cuenta);

        repoC.guardar(cuenta);

        s.getCuentas().add(cuenta);

        return cuenta;
    }

    public void eliminarCuenta(Cuenta c) {
        repoC.eliminar(c.getId());
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
            throw new RuntimeException("Cuenta no valida");
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

    public Cuenta obtenerCuentaPorId(String numero) {
        Cuenta c = repoC.buscarPorId(numero);
        if (c == null) {
            throw new RuntimeException("Cuenta inexistente");
        }
        return c;
    }

    public List<Sucursal> obtenerSucursales(){
        return repoS.obtenerTodas();
    }
}