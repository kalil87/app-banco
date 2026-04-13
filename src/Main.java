//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //probando metodos de Cuenta
        Banco banco = new Banco("ICBC", "Jujuy 1500");
        Cliente cliente1 = new Cliente("Juan Gomez", "38123456");
        Cliente cliente2 = new Cliente("Diego Pereira", "40123456");
        Cuenta cuenta1 = new Cuenta("abc1", TipoCuenta.CA, cliente1);
        Cuenta cuenta2 = new Cuenta("abc2", TipoCuenta.CA, cliente2);

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

        banco.abrirCuenta("qwe123", TipoCuenta.CA, cliente1);
        banco.abrirCuenta("qwe234", TipoCuenta.CA, cliente2);
        banco.verBalance();
    }
}