public class Cliente extends Usuario {
    private String dni;
    private String nombre;

    public Cliente (String email, String password, String dni, String nombre) {
        super(email, password);
        this.dni = dni;
        this.nombre = nombre;
    }
}