package com.br.ezequielzz.ex3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Livro extends ItemBiblioteca implements Reservavel {
    public Livro(String titulo, String autor) {
        super(titulo, autor);
    }

    @Override
    public void emprestar(Usuario usuario) {
        if (isDisponivel()) {
            System.out.println("Livro '" + titulo + "' emprestado por 14 dias.");
            usuario.adicionarItem(this);
            marcarComoEmprestado();
        } else {
            System.out.println("Livro '" + titulo + "' não está disponível.");
        }
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        return diasAtraso * 1.50; // Exemplo de cálculo de multa para livro
    }

    @Override
    public void reservar() {
        if (isDisponivel()) {
            System.out.println("Livro '" + titulo + "' reservado.");
        } else {
            System.out.println("Livro '" + titulo + "' não pode ser reservado, pois já está emprestado.");
        }
    }
}
