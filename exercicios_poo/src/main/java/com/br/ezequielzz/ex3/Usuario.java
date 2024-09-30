package com.br.ezequielzz.ex3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private String nome;
    private String cpf;
    private List<ItemBiblioteca> itensEmprestados;

    public void adicionarItem(ItemBiblioteca item){
        itensEmprestados.add(item);
    }

    public void devolverItem(ItemBiblioteca item){
        itensEmprestados.remove(item);
        System.out.println("Item devolvido: " + item.getTitulo());
    }

    public List<ItemBiblioteca> getItensEmprestados(){
        return itensEmprestados;
    }
}
