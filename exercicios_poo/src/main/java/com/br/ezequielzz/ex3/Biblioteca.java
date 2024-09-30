package com.br.ezequielzz.ex3;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<ItemBiblioteca> itens;

    public Biblioteca() {
        itens = new ArrayList<>();
        // Adiciona alguns itens de exemplo
        itens.add(new Livro("Java Básico", "Autor A"));
        itens.add(new Revista("Revista Tech", "Autor B"));
        itens.add(new MaterialEletronico("Apostila PDF", "Autor C"));
    }

    // Método para buscar um item pelo título
    public ItemBiblioteca buscarItemPorTitulo(String titulo) {
        for (ItemBiblioteca item : itens) {
            if (item.getTitulo().equalsIgnoreCase(titulo)) {
                return item;
            }
        }
        return null; // Retorna null se o item não for encontrado
    }

    // Método para adicionar um item à biblioteca (se precisar no futuro)
    public void adicionarItem(ItemBiblioteca item) {
        itens.add(item);
    }

    // Método para listar todos os itens da biblioteca
    public List<ItemBiblioteca> listarItens() {
        return itens;
    }
}
