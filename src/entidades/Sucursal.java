package entidades;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {
    String numero;
    String direccion;
    List<Cuenta> cuentas;

    public Sucursal(String numero, String direccion) {
        this.numero = numero;
        this.direccion = direccion;
        this.cuentas = new ArrayList<>();
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }
}