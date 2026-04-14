package entidades;

public class Cliente extends Usuario {
    private String dni;
    private String nombre;
    private Cuenta cuenta;

    public Cliente (String email, String password, String dni, String nombre) {
        super(email, password);
        this.dni = dni;
        this.nombre = nombre;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}