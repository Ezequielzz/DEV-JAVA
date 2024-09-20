package br.com.ezequielzz;

import br.com.ezequielzz.Ex5.AgendaTelefonica;
import br.com.ezequielzz.Ex5.Contato;
import br.com.ezequielzz.Ex5.AgendaException;
import br.com.ezequielzz.Ex5.ContatoNaoEncontradoException;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        AgendaTelefonica agenda = new AgendaTelefonica(5); // Cria uma agenda com capacidade para 5 contatos
        int operador = 0; // Inicializa o operador
        do {
            try {
                // Exibe o menu e captura a opção do usuário
                String input = JOptionPane.showInputDialog("--- Agenda Telefônica ---" +
                        "\n1 - Adicionar contato" +
                        "\n2 - Listar contatos" +
                        "\n3 - Buscar contato" +
                        "\n4 - Remover contato" +
                        "\n5 - Sair");

                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    continue;
                }

                operador = Integer.parseInt(input); // Converte a entrada para um número inteiro

                switch (operador) {
                    case 1: // Adicionar contato
                        String nome = JOptionPane.showInputDialog("Digite o nome do contato:");
                        String telefone = JOptionPane.showInputDialog("Digite o telefone do contato:");
                        Contato novoContato = new Contato(nome, telefone);
                        try {
                            agenda.addContato(novoContato); // Adiciona o contato na agenda
                            JOptionPane.showMessageDialog(null, "Contato adicionado com sucesso!");
                        } catch (AgendaException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                        break;

                    case 2: // Listar contatos
                        agenda.listarContatos();

                    case 3: // Buscar contato
                        String nomeBusca = JOptionPane.showInputDialog("Digite o nome do contato para buscar:");
                        Contato contatoEncontrado = agenda.buscarContato(nomeBusca);
                        JOptionPane.showMessageDialog(null, contatoEncontrado != null ?
                                "Contato encontrado: " + contatoEncontrado.toString() : "Contato não encontrado.");
                        break;

                    case 4: // Remover contato
                        String nomeRemover = JOptionPane.showInputDialog("Digite o nome do contato para remover:");
                        boolean removido = agenda.removerContato(nomeRemover);
                        JOptionPane.showMessageDialog(null, removido ?
                                "Contato removido com sucesso!" : "Contato não encontrado.");
                        break;

                    case 5: // Sair
                        JOptionPane.showMessageDialog(null, "Saindo da Agenda Telefônica.");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número.");
            } catch (ContatoNaoEncontradoException e) {
                throw new RuntimeException(e);
            }
        } while (operador != 5); // Repete o loop até o usuário escolher a opção de sair (5)
    }
}
