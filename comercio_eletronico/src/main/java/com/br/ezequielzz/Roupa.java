package com.br.ezequielzz;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Roupa extends Produto implements Transportavel{
    // Atributos
    private double volume;
    private double peso;

    // Construtor
    public Roupa(String nome, double preco, double volume) {
        super(nome, preco);
        this.volume = volume;
    }

    // Implementando método abstrato
    @Override
    public double calcularPeso() {
        peso = volume * 10;
        return peso;
    }

    // Implementando método da Interface Transportavel
    @Override
    public double calcularFrete() {
        double valorFrete = peso * 5;
        return valorFrete;
    }
}
