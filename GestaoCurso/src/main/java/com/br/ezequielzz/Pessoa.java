package com.br.ezequielzz;

public abstract class Pessoa {
    String nome;
    String cpf;

    public void exibirInformacoes(){
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " +  getCpf());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
