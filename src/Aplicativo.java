import java.util.Scanner;
import java.util.List;

public class Aplicativo {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu Principal:");
            System.out.println("1. Cadastro de Titular");
            System.out.println("2. Cadastro de Conta");
            System.out.println("3. Operar Conta");
            System.out.println("4. Listar Titulares");
            System.out.println("5. Listar Contas");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID do titular: ");
                    String idTitular = scanner.nextLine();
                    System.out.print("Digite o nome do titular: ");
                    String nomeTitular = scanner.nextLine();
                    banco.adicionarTitular(idTitular, nomeTitular);
                    break;
                case 2:
                    System.out.print("Digite o ID do titular da conta: ");
                    idTitular = scanner.nextLine(); // Atribua o valor aqui
                    Titular titular = banco.encontrarTitularPorId(idTitular);
                    if (titular != null) {
                        banco.adicionarConta(idTitular); // Passe o ID do titular
                        System.out.println("Conta cadastrada com sucesso.");
                    } else {
                        System.out.println("Titular não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o ID da conta: ");
                    String idConta = scanner.nextLine();
                    Conta conta = banco.encontrarContaPorId(idConta);
                    if (conta != null) {
                        // Submenu de operações em conta
                        while (true) {
                            System.out.println("Operações em Conta:");
                            System.out.println("1. Sacar");
                            System.out.println("2. Depositar");
                            System.out.println("3. Transferir");
                            System.out.println("4. Mostrar Saldo");
                            System.out.println("5. Voltar ao Menu Principal");
                            System.out.print("Escolha uma operação: ");

                            int operacaoConta = scanner.nextInt();
                            scanner.nextLine(); // Limpar a quebra de linha

                            switch (operacaoConta) {
                                case 1:
                                    System.out.print("Digite o valor para sacar: ");
                                    double valorSaque = scanner.nextDouble();
                                    if (conta.sacar(valorSaque)) {
                                        System.out.println("Saque realizado com sucesso.");
                                    } else {
                                        System.out.println("Saldo insuficiente para sacar.");
                                    }
                                    break;
                                case 2:
                                    System.out.print("Digite o valor para depositar: ");
                                    double valorDeposito = scanner.nextDouble();
                                    conta.depositar(valorDeposito);
                                    System.out.println("Depósito realizado com sucesso.");
                                    break;
                                case 3:
                                    System.out.print("Digite o ID da conta de destino: ");
                                    String idContaDestino = scanner.nextLine();
                                    Conta contaDestino = banco.encontrarContaPorId(idContaDestino);
                                    if (contaDestino != null) {
                                        System.out.print("Digite o valor para transferir: ");
                                        double valorTransferencia = scanner.nextDouble();
                                        if (conta.transferir(contaDestino, valorTransferencia)) {
                                            System.out.println("Transferência realizada com sucesso.");
                                        } else {
                                            System.out.println("Saldo insuficiente para transferir.");
                                        }
                                    } else {
                                        System.out.println("Conta de destino não encontrada.");
                                    }
                                    break;
                                case 4:
                                    System.out.println("Saldo da Conta: " + conta.getSaldo());
                                    break;
                                case 5:
                                    // Voltar ao Menu Principal
                                    break;
                                default:
                                    System.out.println("Opção inválida. Tente novamente.");
                            }

                            if (operacaoConta == 5) {
                                break; // Sair do submenu de operações em conta
                            }
                        }
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 4:
                    List<Titular> titulares = banco.listarTitulares();
                    System.out.println("Lista de Titulares:");
                    for (Titular t : titulares) {
                        System.out.println("ID: " + t.getId() + " | Nome: " + t.getNome());
                    }
                    break;
                case 5:
                    List<Conta> contas = banco.listarContas();
                    System.out.println("Lista de Contas:");
                    for (Conta c : contas) {
                        System.out.println("ID: " + c.getId() + " | Titular: " + c.getTitular().getNome() + " | Saldo: " + c.getSaldo());
                    }
                    break;
                case 6:
                    System.out.println("Saindo do programa. Até logo!");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
