package Ex5;

import java.util.Scanner;

public class AgendaTelefonica {
    private Contato[] contatos;
    private int contador;

    // Limite máximo de contatos
    private static final int LIMITE_CONTATOS = 100;

    public AgendaTelefonica() {
        contatos = new Contato[LIMITE_CONTATOS];
        contador = 0;
    }

    // Método para adicionar contato
    public void adicionarContato(String nome, String telefone) throws AgendaCheiaException {
        if (contador >= LIMITE_CONTATOS) {
            throw new AgendaCheiaException("Erro: A agenda está cheia.");
        }
        contatos[contador++] = new Contato(nome, telefone);
        System.out.println("Contato adicionado com sucesso!");
    }

    // Método para buscar contato por nome
    public Contato buscarContato(String nome) throws ContatoNaoEncontradoException {
        for (int i = 0; i < contador; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                return contatos[i];
            }
        }
        throw new ContatoNaoEncontradoException("Erro: Contato '" + nome + "' não encontrado.");
    }

    // Método para remover contato por nome
    public void removerContato(String nome) throws ContatoNaoEncontradoException {
        boolean encontrado = false;
        for (int i = 0; i < contador; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                // Deslocar os contatos para preencher o espaço vazio
                for (int j = i; j < contador - 1; j++) {
                    contatos[j] = contatos[j + 1];
                }
                contatos[--contador] = null; // Reduz o contador e remove o último
                encontrado = true;
                System.out.println("Contato removido com sucesso!");
                break;
            }
        }
        if (!encontrado) {
            throw new ContatoNaoEncontradoException("Erro: Contato '" + nome + "' não encontrado.");
        }
    }

    // Método para listar todos os contatos
    public void listarContatos() {
        if (contador == 0) {
            System.out.println("Agenda vazia.");
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.println(contatos[i]);
            }
        }
    }

    public void rodar() {
        Scanner scanner = new Scanner(System.in);
        AgendaTelefonica agenda = new AgendaTelefonica();
        int opcao;
        boolean ligado = true;

        while (ligado) {
            // Menu de opções
            System.out.println("\n--- Agenda Telefônica ---");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Remover contato");
            System.out.println("3. Buscar contato");
            System.out.println("4. Listar contatos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            try {
                switch (opcao) {
                    case 1:
                        // Adicionar contato
                        System.out.print("Digite o nome do contato: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o telefone do contato: ");
                        String telefone = scanner.nextLine();
                        agenda.adicionarContato(nome, telefone);
                        break;
                    case 2:
                        // Remover contato
                        System.out.print("Digite o nome do contato a ser removido: ");
                        nome = scanner.nextLine();
                        agenda.removerContato(nome);
                        break;
                    case 3:
                        // Buscar contato
                        System.out.print("Digite o nome do contato a ser buscado: ");
                        nome = scanner.nextLine();
                        Contato contato = agenda.buscarContato(nome);
                        System.out.println(contato);
                        break;
                    case 4:
                        // Listar todos os contatos
                        agenda.listarContatos();
                        break;
                    case 5:
                        // Sair
                        System.out.println("Saindo da agenda...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (ContatoNaoEncontradoException | AgendaCheiaException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
