public class Cuenta {
    private String numero;
    private double saldo;
    private TipoCuenta tipoDeCuenta;

    public Cuenta(String numero, double saldo, TipoCuenta tipo) {
        this.numero = numero;
        this.saldo = saldo;
        this.tipoDeCuenta = tipo;
    }

    private double getSaldo() {
        return saldo;
    }

    public void verDatos() {
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
