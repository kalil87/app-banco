public class Cuenta {
    private String numero;
    private double saldo;
    private TipoCuenta tipoDeCuenta;
    private Cliente cliente;

    public Cuenta(String numero, TipoCuenta tipo, Cliente cliente) {
        this.numero = numero;
        this.saldo = 0;
        this.tipoDeCuenta = tipo;
        this.cliente = cliente;
    }

    private double getSaldo() {
        return saldo;
    }

    public void verDatos() {
        System.out.println("cliente: " + cliente.getNombre());
        System.out.println("dni: " + cliente.getDni());
        System.out.println("cuenta numero: " + numero);
        System.out.println("saldos: " + getSaldo());
        System.out.println("tipo de cuenta: " + tipoDeCuenta + "\n");
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double monto) {
        setSaldo(this.saldo + monto);
    }

    public void retirar(double monto) {
        setSaldo(this.saldo - monto);
    }

    public void transferir(Cuenta cuentaDestino, double monto) {
        retirar(monto);
        cuentaDestino.depositar(monto);
    }
}
