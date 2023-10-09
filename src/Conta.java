public class Conta {
    private String id;
    private Titular titular;
    private double saldo;

    public Conta(String id, Titular titular) {
        this.id = id;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public String getId() {
        return id;
    }

    public Titular getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferir(Conta destino, double valor) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    // Outros métodos relacionados a Conta
}
