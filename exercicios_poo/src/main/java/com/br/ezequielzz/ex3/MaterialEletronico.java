package com.br.ezequielzz.ex3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MaterialEletronico extends ItemBiblioteca {
    public MaterialEletronico(String titulo, String autor) {
        super(titulo, autor);
    }


    @Override
    public void emprestar(Usuario usuario) {
        // Lógica para emprestar revista
        System.out.println("Material eletrônico emprestado por 7 dias: " + titulo);
        usuario.adicionarItem(this);
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        return diasAtraso * 5.00; // Multa para material eletrônico
    }
}
