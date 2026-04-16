package entidades;

public class Cuenta {
    private String id;
    private TipoCuenta tipo;
    private double saldo;
    private Usuario titular;
    private Sucursal sucursal;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Cuenta cuenta = new Cuenta();

        public Builder id(String id) {
            cuenta.id = id;
            return this;
        }

        public Builder tipo(TipoCuenta tipo) {
            cuenta.tipo = tipo;
            return this;
        }

        public Builder saldo(double saldo) {
            cuenta.saldo = saldo;
            return this;
        }

        public Builder titular(Usuario titular) {
            cuenta.titular = titular;
            return this;
        }

        public Builder sucursal(Sucursal sucursal) {
            cuenta.sucursal = sucursal;
            return this;
        }

        public Cuenta build() {
            return cuenta;
        }
    }

    public double getSaldo() { return saldo; }

    public void setSaldo(double saldo) { this.saldo = saldo; }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public String getId() {
        return id;
    }
}