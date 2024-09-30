package com.br.ezequielzz.ex3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Livro extends ItemBiblioteca implements Reservavel{
    private final int diasEmprestimo = 14;

    public Livro(String titulo, String autor, boolean disponivel) {
        super(titulo, autor, disponivel);
    }

    @Override
    public void emprestar(Usuario usuario) {
        if (disponivel) {
            this.disponivel = false;
            this.dataEmprestimo = LocalDate.now();
            this.dataDevolucao = dataEmprestimo.plusDays(DIAS_EMPRESTIMO); // Data de devolução
            usuario.adicionarItem(this);
            System.out.println("Livro '" + titulo + "' emprestado por 14 dias.");
        } else {
            System.out.println("Livro '" + titulo + "' não está disponível.");
        }
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        return diasAtraso * 1.50;
    }

    @Override
    public void reservar() {
        // Lógica para reservar o livro
        System.out.println("Livro Reservado " + titulo);
    }
}
