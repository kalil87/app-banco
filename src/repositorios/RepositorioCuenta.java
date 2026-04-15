package repositorios;

import entidades.Cuenta;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCuenta {
    private List<Cuenta> cuentas = new ArrayList<>();

    public void guardar(Cuenta c) {
        cuentas.add(c);
    }

    public void eliminar(String id) {
        cuentas.removeIf(c -> c.getId().equals(id));
    }

    public Cuenta buscarPorId(String id) {
        return cuentas.stream()
                .filter(cue -> cue.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Cuenta> obtenerTodas() {
        return cuentas;
    }
}