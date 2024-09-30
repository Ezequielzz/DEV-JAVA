package com.br.ezequielzz.ex3;

import java.util.ArrayList;
import java.util.List;

public class HistoricoEmprestimos {
    private List<ItemBiblioteca> historico;

    public HistoricoEmprestimos() {
        historico = new ArrayList<>();
    }

    public void adicionarAoHistorico(ItemBiblioteca item) {
        historico.add(item);
        System.out.println("Adicionado ao histórico: " + item.getTitulo());
    }

    public List<ItemBiblioteca> getHistorico() {
        return historico;
    }
}
