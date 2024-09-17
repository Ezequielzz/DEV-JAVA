package Ex4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FatorialComRecursao {
    // Método recursivo para calcular o fatorial
    public static int calcularFatorial(int n) throws ValorInvalidoException {
        if (n < 0) {
            throw new ValorInvalidoException("Erro: O número deve ser um inteiro positivo.");
        }
        if (n == 0 || n == 1) {
            return 1; // Base da recursão
        }
        return n * calcularFatorial(n - 1); // Chamada recursiva
    }

    public void rodar() {
        Scanner scanner = new Scanner(System.in);
        boolean entradaValida = false;

        // Loop para garantir que o usuário insira um número válido
        while (!entradaValida) {
            try {
                System.out.print("Digite um número inteiro positivo para calcular o fatorial: ");
                int numero = scanner.nextInt();

                // Calcula o fatorial e exibe o resultado
                int resultado = calcularFatorial(numero);
                System.out.println("Fatorial de " + numero + " é: " + resultado);
                entradaValida = true; // Saída do loop se não houver erro

            } catch (ValorInvalidoException e) {
                System.out.println(e.getMessage()); // Exibe mensagem da exceção personalizada
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número inteiro.");
                scanner.nextLine(); // Limpa o buffer de entrada para evitar loop infinito
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
