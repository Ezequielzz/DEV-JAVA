package Ex2;
import java.util.Scanner;
import java.util.ArrayList;

public class CadastroFuncionarios {
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public void rodar() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        boolean ligado = true;

        while (ligado) {
            System.out.println("\n1. Adicionar Funcionário");
            System.out.println("2. Remover Funcionário");
            System.out.println("3. Listar Funcionários");
            System.out.println("4. Calcular Média Salarial");
            System.out.println("5. Sair");
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar

            switch (opcao) {
                case 1:
                    adicionarFuncionario(scanner);
                    break;
                case 2:
                    removerFuncionario(scanner);
                    break;
                case 3:
                    listarFuncionarios();
                    break;
                case 4:
                    calcularMediaSalarial();
                    break;
                case 5:
                    System.out.println("Encerrando...");
                    ligado = false;
                    break;

                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        }
        scanner.close();
    }

    // Métodos

    // Método para adicionar Funcionários
    public void adicionarFuncionario(Scanner scanner) {
        try {
            System.out.print("Digite o nome do funcionário: ");
            String nome = scanner.nextLine();
            System.out.print("Digite a idade do funcionário: ");
            int idade = scanner.nextInt();
            System.out.print("Digite o salário do funcionário: ");
            double salario = scanner.nextDouble();
            funcionarios.add(new Funcionario(nome, idade, salario));
            System.out.println("Funcionário adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar funcionário. Verifique os dados.");
            scanner.nextLine();
        }
    }

    // Método de Remover Usuário
    public void removerFuncionario(Scanner scanner) {
        try {
            System.out.print("Digite o nome do funcionário a ser removido: ");
            String nome = scanner.nextLine();
            boolean encontrado = false;

            for (Funcionario funcionario : funcionarios) {
                if (funcionario.nome.equalsIgnoreCase(nome)) {
                    funcionarios.remove(funcionario);
                    System.out.println("Funcionário removido com sucesso!");
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Funcionário não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao remover funcionário.");
        }
    }

    // Método para listar todos os Funcionários
    public void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário encontrado.");
        } else {
            System.out.println("Lista de Funcionários:");
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }
        }
    }

    // Método para calcular a média salarial
    public static void calcularMediaSalarial() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário encontrado para calcular a média salarial.");
        } else {
            double somaSalarios = 0;
            for (Funcionario funcionario : funcionarios) {
                somaSalarios += funcionario.salario;
            }
            double media = somaSalarios / funcionarios.size();
            System.out.printf("Média salarial: R$" + media);
        }
    }

}