package servicios;

import entidades.Usuario;
import java.util.List;

public class ServicioDeValidacion {
    private List<Usuario> usuarios;

    public ServicioDeValidacion(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario login(String email, String password) {

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }

        return null;
    }
}