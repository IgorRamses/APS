import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Titular> titulares;
    private List<Conta> contas;

    public Banco() {
        titulares = new ArrayList<>();
        contas = new ArrayList<>();
    }

    public void adicionarTitular(String id, String nome) {
        Titular titular = new Titular(id, nome);
        titulares.add(titular);
    }

    public void adicionarConta(String idTitular) {
        Titular titular = encontrarTitularPorId(idTitular);
        if (titular != null) {
            Conta conta = new Conta(idTitular, titular);
            contas.add(conta);
        } else {
            System.out.println("Titular não encontrado.");
        }
    }

    public void depositar(String contaId, double valor) {
        Conta conta = encontrarContaPorId(contaId);
        if (conta != null) {
            conta.depositar(valor);
        }
    }

    public boolean sacar(String contaId, double valor) {
        Conta conta = encontrarContaPorId(contaId);
        if (conta != null) {
            return conta.sacar(valor);
        }
        return false;
    }

    public boolean transferir(String origemId, String destinoId, double valor) {
        Conta origem = encontrarContaPorId(origemId);
        Conta destino = encontrarContaPorId(destinoId);

        if (origem != null && destino != null) {
            return origem.transferir(destino, valor);
        }
        return false;
    }

    Conta encontrarContaPorId(String id) {
        for (Conta conta : contas) {
            if (conta.getId().equals(id)) {
                return conta;
            }
        }
        return null;
    }

    public Titular encontrarTitularPorId(String id) {
        for (Titular titular : titulares) {
            if (titular.getId().equals(id)) {
                return titular;
            }
        }
        return null;
    }

    public List<Titular> listarTitulares() {
        return titulares;
    }

    public List<Conta> listarContas() {
        return contas;
    }
}