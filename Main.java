import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria conta = new ContaBancaria(600.0); // Inicializa com > 500 para testar o limite
        Carro carro = new Carro();
        int opcaoPrincipal = -1;

        while (opcaoPrincipal != 0) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Exercício - Conta Bancária");
            System.out.println("2. Exercício - Carro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcaoPrincipal = scanner.nextInt();

            if (opcaoPrincipal == 1) {
                menuConta(scanner, conta);
            } else if (opcaoPrincipal == 2) {
                menuCarro(scanner, carro);
            } else if (opcaoPrincipal != 0) {
                System.out.println("Opção inválida.");
            }
        }

        System.out.println("Sistema encerrado.");
        scanner.close();
    }

    private static void menuConta(Scanner scanner, ContaBancaria conta) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- MENU CONTA BANCÁRIA ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Consultar cheque especial");
            System.out.println("3. Depositar dinheiro");
            System.out.println("4. Sacar dinheiro");
            System.out.println("5. Pagar boleto");
            System.out.println("6. Verificar uso de cheque especial");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1: conta.consultarSaldo(); break;
                case 2: conta.consultarChequeEspecial(); break;
                case 3:
                    System.out.print("Valor do depósito: ");
                    conta.depositar(scanner.nextDouble());
                    break;
                case 4:
                    System.out.print("Valor do saque: ");
                    conta.sacar(scanner.nextDouble());
                    break;
                case 5:
                    System.out.print("Valor do boleto: ");
                    conta.pagarBoleto(scanner.nextDouble());
                    break;
                case 6:
                    System.out.println(conta.usandoChequeEspecial() ? "Sim, está usando." : "Não está usando.");
                    break;
                case 0: break;
                default: System.out.println("Inválido.");
            }
        }
    }

    private static void menuCarro(Scanner scanner, Carro carro) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- MENU CARRO ---");
            System.out.println("1. Ligar carro");
            System.out.println("2. Desligar carro");
            System.out.println("3. Acelerar");
            System.out.println("4. Diminuir velocidade");
            System.out.println("5. Virar (Esquerda/Direita)");
            System.out.println("6. Verificar velocidade");
            System.out.println("7. Trocar marcha");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1: carro.ligar(); break;
                case 2: carro.desligar(); break;
                case 3: carro.acelerar(); break;
                case 4: carro.diminuirVelocidade(); break;
                case 5:
                    System.out.print("Direção (Esquerda/Direita): ");
                    carro.virar(scanner.next());
                    break;
                case 6: carro.verificarVelocidade(); break;
                case 7:
                    System.out.print("Nova marcha (0 a 6): ");
                    carro.trocarMarcha(scanner.nextInt());
                    break;
                case 0: break;
                default: System.out.println("Inválido.");
            }
        }
    }
}
