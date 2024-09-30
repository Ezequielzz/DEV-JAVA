package Ex6;

import java.util.Scanner;

public class SistemaEstoque {

    public static void main(String[] args) {
        Estoque estoque = new Estoque("estoque.txt");
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;

        while (rodando) {
            System.out.println("\nSistema de Gerenciamento de Estoque:");
            System.out.println("1. Adicionar item");
            System.out.println("2. Remover item");
            System.out.println("3. Listar itens");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do item: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    estoque.adicionarItem(new Item(nome, quantidade));
                    break;
                case 2:
                    System.out.print("Digite o nome do item a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    estoque.removerItem(nomeRemover);
                    break;
                case 3:
                    estoque.listarItens();
                    break;
                case 4:
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
