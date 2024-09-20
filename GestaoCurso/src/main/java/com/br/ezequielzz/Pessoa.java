package com.br.ezequielzz;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
public abstract class Pessoa {
    private String nome;
    private String cpf;

    public void exibirInformacoes() {
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
    }
}
