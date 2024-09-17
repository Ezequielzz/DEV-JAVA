package Ex3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraAvancada {
    public void rodar() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        boolean ligado = true;

        while (ligado) {
            // Menu
            System.out.println("\n--- Calculadora Avançada ---");
            System.out.println("1. Soma");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");
            System.out.println("5. Raiz Quadrada");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Digite um número.");
                scanner.nextLine();
                continue;
            }

            try {
                double num1 = 0, num2 = 0;
                Operacao operacao = null;

                if (opcao != 5) { // Raiz quadrada só precisa de um número
                    System.out.print("Digite o primeiro número: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Digite o segundo número: ");
                    num2 = scanner.nextDouble();
                } else {
                    System.out.print("Digite o número: ");
                    num1 = scanner.nextDouble();
                }

                // Escolher operação com base na opção do usuário
                switch (opcao) {
                    case 1:
                        operacao = new Soma();
                        break;
                    case 2:
                        operacao = new Subtracao();
                        break;
                    case 3:
                        operacao = new Multiplicacao();
                        break;
                    case 4:
                        operacao = new Divisao();
                        break;
                    case 5:
                        operacao = new RaizQuadrada();
                        System.out.println("Resultado: " + ((RaizQuadrada) operacao).calcular(num1));
                        break;
                    case 6:
                    System.out.println("Encerrando...");
                        ligado = false;
                    default:
                        System.out.println("Opção inválida!");
                        continue;
                }

                // Executa a operação e exibe o resultado
                double resultado = operacao.calcular(num1, num2);
                System.out.println("Resultado: " + resultado);

            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Digite um número válido.");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
