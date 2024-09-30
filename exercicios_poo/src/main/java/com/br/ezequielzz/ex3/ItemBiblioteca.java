package com.br.ezequielzz.ex3;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class ItemBiblioteca {
    private String titulo;
    private String autor;
    private boolean disponivel;

    // Método Abstrato
    public abstract void emprestar(Usuario usuario);

    // Método para calcular multa por atraso (será sobrescrito pois depende do tipo de item)
    public abstract double calcularMulta(int diasAtraso);

    // Método para devolver item
    public void devolver(Usuario usuario) {
        if (!disponivel) {
            this.disponivel = true;
            usuario.devolverItem(this);
            System.out.println("Item '" + titulo + "' devolvido.");
        } else {
            System.out.println("Erro: Item '" + titulo + "' já está disponível.");
        }
    }
}
