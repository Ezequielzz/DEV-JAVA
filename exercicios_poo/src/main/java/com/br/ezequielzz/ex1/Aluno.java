package com.br.ezequielzz;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Aluno extends Pessoa implements Avaliavel {
    private int matricula;
    private List<Double> notas  = new ArrayList<>();

    public void addNota(double nota) {
        notas.add(nota); // Método para adicionar nota à lista
    }

    @Override
    public void avaliarDesempenho() {
        double soma = 0;
        for (Double nota : notas) {
            soma += nota;
        }

        double media = notas.isEmpty() ? 0 : soma / notas.size();
        System.out.println("Média do Aluno " + getNome() + ": " + media);

        if (media >= 7.0) {
            System.out.println("Status: Aprovado");
        } else if (media >= 5 && media < 7) {
            System.out.println("Status: Recuperação");
        }else {
            System.out.println("Status: Reprovado");
        }
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Matrícula: " + getMatricula());
    }
}
