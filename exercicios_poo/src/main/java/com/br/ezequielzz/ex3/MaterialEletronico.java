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
        if (isDisponivel()) {
            System.out.println("Material eletrônico '" + titulo + "' emprestado por 7 dias.");
            usuario.adicionarItem(this);
            marcarComoEmprestado();
        } else {
            System.out.println("Material eletrônico '" + titulo + "' não está disponível.");
        }
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        return diasAtraso * 5.00; // Exemplo de cálculo de multa para material eletrônico
    }

}
