package com.br.ezequielzz.ex3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Revista extends ItemBiblioteca {
    public Revista(String titulo, String autor) {
        super(titulo, autor);
    }

    @Override
    public void emprestar(Usuario usuario) {
        if (isDisponivel()) {
            System.out.println("Revista '" + titulo + "' emprestada por 7 dias.");
            usuario.adicionarItem(this);
            marcarComoEmprestado();
        } else {
            System.out.println("Revista '" + titulo + "' não está disponível.");
        }
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        return diasAtraso * 2.00; // Exemplo de cálculo de multa para revista
    }
}
