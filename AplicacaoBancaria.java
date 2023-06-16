package bancaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Conta {
    private String numero;
    private String nome;
    private double saldo;

    public Conta(String numero, String nome) {
        this.numero = numero;
        this.nome = nome;
        this.saldo = 0.0;
    }

    public String getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }

    public void solicitarEmprestimo(double valor) {
        // Implemente aqui a lógica para solicitar um empréstimo
        System.out.println("Empréstimo de R$" + valor + " solicitado com sucesso.");
    }
}

class Banco {
    private List<Conta> contas;

    public Banco() {
        contas = new ArrayList<>();
    }

    public void criarContaPessoaFisica(String numero, String nome) {
        Conta conta = new Conta(numero, nome);
        contas.add(conta);
        System.out.println("Conta Pessoa Física criada com sucesso.");
    }

    public void criarContaPessoaJuridica(String numero, String nome) {
        Conta conta = new Conta(numero, nome);
        contas.add(conta);
        System.out.println("Conta Pessoa Jurídica criada com sucesso.");
    }

    public Conta buscarContaPorNumero(String numero) {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numero)) {
                return conta;
            }
        }
        return null;
    }

    public List<Conta> buscarContaPorNome(String nome) {
        List<Conta> contasEncontradas = new ArrayList<>();
        for (Conta conta : contas) {
            if (conta.getNome().equalsIgnoreCase(nome)) {
                contasEncontradas.add(conta);
            }
        }
        return contasEncontradas;
    }
}

public class AplicacaoBancaria {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 5) {
            System.out.println("----- MENU -----");
            System.out.println("1. Criar conta");
            System.out.println("2. Buscar conta");
            System.out.println("3. Acessar conta");
            System.out.println("4. Sair da aplicação");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("----- CRIAR CONTA -----");
                    System.out.println("1. Pessoa Física");
                    System.out.println("2. Pessoa Jurídica");
                    System.out.print("Escolha o tipo de conta: ");
                    int tipoConta = scanner.nextInt();

                    System.out.print("Digite o número da conta: ");
                    String numeroConta = scanner.next();
                    System.out.print("Digite o nome do titular da conta: ");
                    String nomeTitular = scanner.next();

                    if (tipoConta == 1) {
                        banco.criarContaPessoaFisica(numeroConta, nomeTitular);
                    } else if (tipoConta == 2) {
                        banco.criarContaPessoaJuridica(numeroConta, nomeTitular);
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 2:
                    System.out.println("----- BUSCAR CONTA -----");
                    System.out.println("1. Buscar por número de conta");
                    System.out.println("2. Buscar por nome do titular");
                    System.out.print("Escolha o tipo de busca: ");
                    int tipoBusca = scanner.nextInt();

                    if (tipoBusca == 1) {
                        System.out.print("Digite o número da conta: ");
                        String numeroBusca = scanner.next();
                        Conta contaNumero = banco.buscarContaPorNumero(numeroBusca);
                        if (contaNumero != null) {
                            System.out.println("Conta encontrada:");
                            System.out.println("Número: " + contaNumero.getNumero());
                            System.out.println("Nome do titular: " + contaNumero.getNome());
                            System.out.println("Saldo: R$" + contaNumero.getSaldo());
                        } else {
                            System.out.println("Conta não encontrada.");
                        }
                    } else if (tipoBusca == 2) {
                        System.out.print("Digite o nome do titular: ");
                        String nomeBusca = scanner.next();
                        List<Conta> contasNome = banco.buscarContaPorNome(nomeBusca);
                        if (!contasNome.isEmpty()) {
                            System.out.println("Contas encontradas:");
                            for (Conta conta : contasNome) {
                                System.out.println("Número: " + conta.getNumero());
                                System.out.println("Nome do titular: " + conta.getNome());
                                System.out.println("Saldo: R$" + conta.getSaldo());
                                System.out.println("-------------------");
                            }
                        } else {
                            System.out.println("Contas não encontradas.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 3:
                    System.out.println("----- ACESSAR CONTA -----");
                    System.out.print("Digite o número da conta: ");
                    String numeroContaAcesso = scanner.next();
                    Conta contaAcesso = banco.buscarContaPorNumero(numeroContaAcesso);
                    if (contaAcesso != null) {
                        int opcaoConta = 0;
                        while (opcaoConta != 5) {
                            System.out.println("----- MENU DA CONTA -----");
                            System.out.println("1. Verificar saldo");
                            System.out.println("2. Realizar saque");
                            System.out.println("3. Realizar depósito");
                            System.out.println("4. Solicitar empréstimo");
                            System.out.println("5. Sair da conta");
                            System.out.print("Escolha uma opção: ");
                            opcaoConta = scanner.nextInt();

public class Conta {
    private String numero;
    private double saldo;
    private String tipo;

    // Construtor
    public Conta(String numero, double saldo, String tipo) {
        this.numero = numero;
        this.saldo = saldo;
        this.tipo = tipo;
    }

    // Getters e Setters

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Método para transferir saldo entre contas
    public static void transferirSaldo(Conta origem, Conta destino, double valor) {
        if (origem.getSaldo() >= valor) {
            origem.setSaldo(origem.getSaldo() - valor);
            destino.setSaldo(destino.getSaldo() + valor);
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para realizar a transferência.");
        }
    }

    public static void main(String[] args) {
        // Criando contas de teste
        Conta pessoaJuridica = new Conta("1234", 1000.0, "Pessoa Jurídica");
        Conta pessoaFisica = new Conta("5678", 500.0, "Pessoa Física");

        // Realizando a transferência de saldo
        transferirSaldo(pessoaJuridica, pessoaFisica, 500.0);

        // Imprimindo os saldos após a transferência
        System.out.println("Saldo da Pessoa Jurídica: " + pessoaJuridica.getSaldo());
        System.out.println("Saldo da Pessoa Física: " + pessoaFisica.getSaldo());
                      
                            switch (opcaoConta) {
                                case 1:
                                    System.out.println("Saldo: R$" + contaAcesso.getSaldo());
                                    break;
                                case 2:
                                    System.out.print("Digite o valor do saque: ");
                                    double valorSaque = scanner.nextDouble();
                                    contaAcesso.sacar(valorSaque);
                                    break;
                                case 3:
                                    System.out.print("Digite o valor do depósito: ");
                                    double valorDeposito = scanner.nextDouble();
                                    contaAcesso.depositar(valorDeposito);
                                    break;
                                case 4:
                                    System.out.print("Digite o valor do empréstimo: ");
                                    double valorEmprestimo = scanner.nextDouble();
                                    contaAcesso.solicitarEmprestimo(valorEmprestimo);
                                    break;
                                case 5:
                                    System.out.println("Saindo da conta...");
                                    break;
                                default:
                                    System.out.println("Opção inválida.");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 4:
                    System.out.println("Saindo da aplicação...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
            System.out.println("-------------------");
        }
        scanner.close();
    }
}


