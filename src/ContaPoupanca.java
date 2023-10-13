public class ContaPoupanca extends Conta {
    private double saldo;

    public ContaPoupanca(String id, Titular titular) {
        super(id, titular); 
    }
    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }
}
