public class ContaCorrente extends Conta {
    private double saldo;

    public ContaCorrente(String id, Titular titular) {
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

    public boolean transferir(Conta destino, double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            destino.depositar(valor);
            return true;
        }
        return false;
    }
}
