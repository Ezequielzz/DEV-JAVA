package Ex6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Item> itens;
    private String arquivoEstoque;

    public Estoque(String arquivoEstoque) {
        this.itens = new ArrayList<>();
        this.arquivoEstoque = arquivoEstoque;
        carregarEstoque();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
        salvarEstoque();
    }

    public void removerItem(String nomeItem) {
        itens.removeIf(item -> item.getNome().equalsIgnoreCase(nomeItem));
        salvarEstoque();
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            for (Item item : itens) {
                System.out.println(item.getNome() + " - Quantidade: " + item.getQuantidade());
            }
        }
    }

    private void salvarEstoque() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoEstoque))) {
            for (Item item : itens) {
                writer.write(item.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o estoque: " + e.getMessage());
        }
    }

    private void carregarEstoque() {
        File file = new File(arquivoEstoque);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    itens.add(Item.fromString(linha));
                }
            } catch (IOException e) {
                System.out.println("Erro ao carregar o estoque: " + e.getMessage());
            }
        } else {
            System.out.println("Arquivo de estoque não encontrado. Criando novo estoque.");
        }
    }
}
