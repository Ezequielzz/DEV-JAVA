package com.br.ezequielzz;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Eletronico extends Produto implements Transportavel {
    // Atributos
    private double volume;
    private double peso;

    // Construtor
    public Eletronico(String nome, double preco, double volume) {
        super(nome, preco);
        this.volume = volume;
    }

    // Implementando método abstrato
    @Override
    public double calcularPeso() {
        peso = volume * 150;
        return peso;
    }

    // Implementando método da Interface Transportavel
    @Override
    public double calcularFrete() {
        double valorFrete = calcularPeso() * 1;
        return valorFrete;
    }
}
