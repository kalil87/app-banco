package entidades;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nombre;
    private String direccion;
    private List<Sucursal> sucursales;
    private static Banco instancia;

    private Banco(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.sucursales = new ArrayList<>();
    }

    public static Banco getInstance(String nombre, String direccion) {
        if (instancia == null) {
            instancia = new Banco(nombre, direccion);
        }
        return instancia;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }
}