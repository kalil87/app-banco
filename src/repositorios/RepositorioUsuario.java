package repositorios;

import entidades.Usuario;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuario {
    private List<Usuario> usuarios = new ArrayList<>();

    public void guardar(Usuario u) {
        usuarios.add(u);
    }

    public List<Usuario> obtenerTodos() {
        return usuarios;
    }
}
