package com.br.ezequielzz.exercicio1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Produto {
    // Atributos
    private String nome;
    private double preco;

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", preco=" + preco + '}';
    }
}
