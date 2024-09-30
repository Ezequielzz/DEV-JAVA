package com.br.ezequielzz.ex3;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class ItemBiblioteca {
    protected String titulo;
    protected String autor;
    private boolean disponivel = true;

    public ItemBiblioteca(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    // Método abstrato para emprestar
    public abstract void emprestar(Usuario usuario);

    // Método para calcular multa por atraso (pode ser sobrescrito)
    public abstract double calcularMulta(int diasAtraso);

    // Marca o item como emprestado
    public void marcarComoEmprestado() {
        this.disponivel = false;
    }

    // Marca o item como disponível
    public void marcarComoDisponivel() {
        this.disponivel = true;
    }
}
