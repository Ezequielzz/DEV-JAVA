package com.br.ezequielzz;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Métodos
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Produto {
    // Atributos
    private String nome;
    private double preco;

    // Método abstrato
    public abstract double calcularPeso();
}
