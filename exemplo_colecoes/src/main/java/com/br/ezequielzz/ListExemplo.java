package com.br.ezequielzz;

import java.util.ArrayList;
import java.util.List;

public class ListExemplo {
    private List<String> nomes;

    public ListExemplo() {
        nomes = new ArrayList<>();
    }

    // Adicionar
    public void addList(String nome) {
        nomes.add(nome);
        System.out.println("Nome adicionado com sucesso");
        System.out.println(nomes.lastIndexOf(nome));
    }

    // Listar
    public void listarNomes() {
        System.out.println(nomes);
    }

    public void removerNome(String nome) {
        try {
            nomes.remove(nome);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Atualizar
    public void atualizarNome(String nomeAntigo, String nomeNovo) {
        try {
            int index = nomes.indexOf(nomeAntigo);
            nomes.set(index, nomeNovo);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
