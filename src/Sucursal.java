import java.util.ArrayList;
import java.util.List;

class Sucursal {
    String numero;
    String direccion;
    List<Cuenta> cuentas;

    public Sucursal(String numero, String direccion) {
        this.numero = numero;
        this.direccion = direccion;
        this.cuentas = new ArrayList<>();
    }
}