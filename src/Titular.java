import java.util.List;

public class Titular {
    private String id;
    private String nome;
    private List<Conta> contas;

    public Titular(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public List<Conta> listarContas() {
        return contas;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome;
    }
}