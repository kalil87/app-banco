//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //probando metodos de Cuenta
        Cuenta cuenta1 = new Cuenta("abc1", 0, TipoCuenta.CA);
        Cuenta cuenta2 = new Cuenta("abc2", 0, TipoCuenta.CA);

        cuenta1.verDatos();
        cuenta2.verDatos();

        cuenta1.depositar(10000);
        cuenta2.depositar(20000);

        cuenta1.verDatos();
        cuenta2.verDatos();

        cuenta1.retirar(1000);
        cuenta1.transferir(cuenta2, 4000);

        cuenta1.verDatos();
        cuenta2.verDatos();
    }
}