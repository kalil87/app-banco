public class Admin extends Usuario {
    private String id;
    private String nombre;

    public Admin(String email, String password, String id, String nombre) {
        super(email, password);
        this.id = id;
        this.nombre = nombre;
    }
}