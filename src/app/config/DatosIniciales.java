package app.config;

import entidades.Banco;
import entidades.Sucursal;
import entidades.Usuario;

import java.util.List;

public class DatosIniciales {

    private Banco banco;
    private List<Usuario> usuarios;
    private List<Sucursal> sucursales;

    public DatosIniciales(Banco banco, List<Usuario> usuarios, List<Sucursal> sucursales) {
        this.banco = banco;
        this.usuarios = usuarios;
        this.sucursales = sucursales;
    }

    public Banco getBanco() {
        return banco;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }
}