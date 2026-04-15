package repositorios;

import entidades.Sucursal;

import java.util.ArrayList;
import java.util.List;

public class RepositorioSucursal {
    private List<Sucursal> sucursales = new ArrayList<>();

    public void guardar(Sucursal s) {
        sucursales.add(s);
    }

    public void eliminar(String numero) {
        sucursales.removeIf(c -> c.getNumero().equals(numero));
    }

    public Sucursal buscarPorId(String numero) {
        return sucursales.stream()
                .filter(suc -> suc.getNumero().equals(numero))
                .findFirst()
                .orElse(null);
    }

    public List<Sucursal> obtenerTodas() {
        return sucursales;
    }
}