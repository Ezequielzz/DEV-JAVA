package br.com.ezequielzz.Ex3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraAvancada {
    double a;
    double b;
    double resultado;
    int escolha;
    Scanner sc = new Scanner(System.in);

    public double soma(double a, double b) {
        resultado = a + b;
        return resultado;
    }

    public double subtracao(double a, double b) {
        resultado = a - b;
        return resultado;
    }

    public double multiplicacao(double a, double b) {
        resultado = a * b;
        return resultado;
    }

    public double divisao(double a, double b) {
        try {
            resultado = a / b;
        } catch (Exception e) {
            System.err.println("Ocorreu um erro" + e);
        }
        return resultado;
    }

    public double raizQuadrada(double a) throws Exception {
        if (a < 0) {
            throw new Exception("Não existe Raiz de Quadrada Negativa");
        }
        try {
            resultado = Math.sqrt(a);
        } catch (Exception e) {
            System.err.println("Ocorreu um erro" + e);
        }
        return resultado;
    }

    // Menu
    public void menu() {
        System.out.println("\n--- Calculadora Avançada ---");
        System.out.println("1. Soma");
        System.out.println("2. Subtração");
        System.out.println("3. Multiplicação");
        System.out.println("4. Divisão");
        System.out.println("5. Raiz Quadrada");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void entradaDados() {
        if (escolha >= 1 && escolha < 5) {
            System.out.println("Digite o valor a: ");
            a = sc.nextDouble();
            System.out.println("Digite o valor b: ");
            b = sc.nextDouble();
        } else if (escolha == 5) {
            System.out.println("Digite o valor a: ");
            a = sc.nextDouble();
        } else if (escolha == 6) {
            System.out.println("Saindo...");
        }
    }

    public void calculadora() {
        do {
            menu();
            try {
                escolha = sc.nextInt();
                switch (escolha) {
                    case 1:
                        entradaDados();
                        soma(a, b);
                        break;
                    case 2:
                        entradaDados();
                        subtracao(a, b);
                        break;
                    case 3:
                        entradaDados();
                        multiplicacao(a, b);
                        break;
                    case 4:
                        entradaDados();
                        divisao(a, b);
                        break;
                    case 5:
                        entradaDados();
                        raizQuadrada(a);
                        break;
                    default:
                        System.out.println("Escolha inválida!");
                        break;
                }
            } catch (Exception e) {
                System.err.println("Ocorreu um erro" + e);
            }
        } while (escolha != 6);
    }
}
