package servicios;

import entidades.Cuenta;
import entidades.Rol;
import entidades.Usuario;
import repositorios.RepositorioUsuario;

public class ServicioUsuario {
    private RepositorioUsuario repo;

    public ServicioUsuario(RepositorioUsuario repo) {
        this.repo = repo;
    }

    public Usuario login(String email, String password) {

        for (Usuario usuario : repo.obtenerTodos()) {
            if (usuario.getEmail().equals(email) && usuario.getPassword().equals(password)) {
                System.out.println("Login exitoso");
                return usuario;
            }
        }

        System.out.println("Login incorrecto");
        return null;
    }

    public void guardar(Usuario u) {
        repo.guardar(u);
    }

    public Cuenta obtenerCuenta(Usuario u) {
        if (!repo.obtenerTodos().contains(u)) {
            throw new RuntimeException("Usuario no valido");
        }
        return u.getCuenta();
    }

    public void validarUsuario(Usuario u) {
        if (u == null) {
            throw new RuntimeException("Usuario no permitido");
        }
    }

    public void vincularCuenta(Usuario u, Cuenta c) {
        u.setCuenta(c);
    }

    public Usuario crearUsuario(String email, String password) {
        Usuario u = new Usuario(email, password, Rol.CLIENTE);
        repo.guardar(u);
        return u;
    }
}