package com.br.ezequielzz;

public class Livro extends Produto implements Transportavel{
    // Atributos

    // Implementando método abstrato
    @Override
    public double calcularPeso() {
        return 0.5;
    }

    // Implementando método da Interface Transportavel
    @Override
    public double calcularFrete() {
        return 2;
    }
}
