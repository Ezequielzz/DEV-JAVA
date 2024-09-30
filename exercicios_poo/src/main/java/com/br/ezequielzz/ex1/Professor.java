package com.br.ezequielzz;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Professor extends Pessoa implements Avaliavel {
    private int salario;

    @Override
    public void exibirInformacoes() {
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Salario: " + getSalario());
    }

    @Override
    public void avaliarDesempenho() {
        int salarioDiario = getSalario() / 22;

        System.out.println("Seu salário diário é: " + salarioDiario);
    }
}
