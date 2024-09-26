package com.br.ezequielzz;

import java.util.Map;

public class MapExemplo {
    private Map<String, Integer> nomesIdades;

    public void addNomeIdade(String nome, int idade) {
        nomesIdades.put(nome, idade);
        System.out.println(nomesIdades.getOrDefault(nome, idade));
    }

    public void listarNomesIdades() {
        System.out.println(nomesIdades);
    }

    public void removerNomeIdade(String nome) {
        nomesIdades.remove(nome);
    }

    public void modificarValor(String nome, int novaIdade) {
        nomesIdades.replace(nome, novaIdade);
    }
}