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
        System.out.println("Revista emprestada por 7 dias: " + titulo);
        usuario.adicionarItem(this);
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        return diasAtraso * 2.00; // Multa maior para revistas
    }
}