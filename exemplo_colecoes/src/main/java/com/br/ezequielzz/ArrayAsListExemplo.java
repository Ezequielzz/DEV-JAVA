package com.br.ezequielzz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAsListExemplo {
    private String[] nomes = {"Maria", "João", "Pedro"};
    private List<String> nomesList;

    public ArrayAsListExemplo() {
        nomesList = new ArrayList<String>(Arrays.asList(nomes));
    }

    public void addArray(String nome) {
        try {
            nomes[3] = nome;
        } catch (Exception e) {
            System.err.println("Erro ao adicionar nome " + e);
        }
    }

    public void addArrayList(String nome) {
        nomesList.add(nome);
        System.out.println("Nome adicionado com sucesso!");
    }

    public void listarNomes() {
        System.out.println(nomesList);
    }
}
