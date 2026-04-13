import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nombre;
    private String direccion;
    private List<Cuenta> cuentas;

    public Banco(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cuentas = new ArrayList<>();
    }

    private List<Cuenta> getCuentas() {
        return new ArrayList<>(this.cuentas);
    }

    public Cuenta abrirCuenta(String numero, TipoCuenta tipo, Cliente cliente) {
        Cuenta cuenta = new Cuenta(numero, tipo, cliente);
        this.cuentas.add(cuenta);
        return cuenta;
    }

    public void verBalance() {
        System.out.println("Banco " + nombre + "\n");
        System.out.println("Balanace:" + "\n");
        for (Cuenta cuenta:getCuentas()) {
            cuenta.verDatos();
        }
    }
}
